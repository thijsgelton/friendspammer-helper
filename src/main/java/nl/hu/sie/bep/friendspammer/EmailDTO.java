package nl.hu.sie.bep.friendspammer;

public class EmailDTO {
    private String to;
    private String from;
    private String subject;
    private String text;
    private Boolean asHtml;

    public EmailDTO(String to, String from, String subject, String text, Boolean asHtml) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.text = text;
        this.asHtml = asHtml;
    }
    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getAsHtml() {
        return asHtml;
    }

    public void setAsHtml(Boolean asHtml) {
        this.asHtml = asHtml;
    }

}
