package com.revature.Spring.payload.response;

public class MessageResponse {

    private String message;

    /**
     * Message response constructor.
     *
     * @param message A String containing the message.
     */
    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
