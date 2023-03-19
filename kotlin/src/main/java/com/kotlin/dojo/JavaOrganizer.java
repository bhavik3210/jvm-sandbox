package com.kotlin.dojo;

public class JavaOrganizer {
    public static void main(String[] args) {
        JavaOrganizer org = new JavaOrganizer();
        org.closeMeeting(null);
    }

    boolean closeMeeting(JavaMeeting meeting) {
        if (meeting.canClose) return meeting.close();
        return false;
    }
}

