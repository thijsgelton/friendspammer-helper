package nl.hu.sie.bep.friendspammer;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;

public class MongoSaver {
    private static Logger logger = LoggerFactory.getLogger(MongoSaver.class);

    public static boolean saveEmail(String to, String from, String subject, String text, Boolean html) {
        String userName = "thijsgelton";
        String password = "geltonthijs";
        String database = "friendspammer";
        String host = "ds247759.mlab.com";
        Integer port = 47759;
        MongoClient mongoClient = createConnection(userName, password, database, host, port);
        boolean success = true;
        try {
            MongoDatabase db = mongoClient.getDatabase(database);

            MongoCollection<Document> c = db.getCollection("email");

            Document doc = new Document("to", to)
                    .append("from", from)
                    .append("subject", subject)
                    .append("text", text)
                    .append("asHtml", html);
            c.insertOne(doc);
        } catch (MongoException mongoException) {
            logger.error("XXXXXXXXXXXXXXXXXX ERROR WHILE SAVING TO MONGO XXXXXXXXXXXXXXXXXXXXXXXXXX");
            logger.error(mongoException.getMessage());
            success = false;
        }

        return success;

    }

    public static ArrayList<EmailDTO> getAllEmails() {
        ArrayList<EmailDTO> emails = new ArrayList<>();
        String userName = "thijsgelton";
        String password = "geltonthijs";
        String database = "friendspammer";
        String host = "ds247759.mlab.com";
        Integer port = 47759;

        MongoClient mongoClient = createConnection(userName, password, database, host, port);
        MongoDatabase db = mongoClient.getDatabase(database);
        MongoCollection<Document> c = db.getCollection("email");
        Iterator<Document> it = c.find().iterator();
        while (it.hasNext()) {
            Document email = it.next();
            String to = (String) email.get("to");
            String from = (String) email.get("from");
            String subject = (String) email.get("subject");
            String text = (String) email.get("text");
            Boolean asHtml = (Boolean) email.get("asHtml");
			emails.add(new EmailDTO(to, from, subject, text, asHtml));
        }
        return emails;
    }

    private static MongoClient createConnection(String username, String password, String database, String host, Integer port) {
        MongoCredential credential = MongoCredential.createCredential(username, database, password.toCharArray());
        ServerAddress address = new ServerAddress(host, port);
        return new MongoClient(address, credential, MongoClientOptions.builder().build());
    }

    public static void main(String... args) {
        logger.debug("test");
    }

}
