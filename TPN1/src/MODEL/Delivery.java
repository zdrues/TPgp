package MODEL;

public class Delivery {
    private int id;
    private String userName;
    private String deliveryAddress;
    private String status;
    private String feedback;

    public Delivery() {
    }

    public Delivery(int id, String userName, String deliveryAddress, String status, String feedback) {
        this.id = id;
        this.userName = userName;
        this.deliveryAddress = deliveryAddress;
        this.status = status;
        this.feedback = feedback;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}