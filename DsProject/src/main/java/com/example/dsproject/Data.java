package com.example.dsproject;

import javafx.beans.property.SimpleStringProperty;

public class Data {

        private final SimpleStringProperty Index;
        private final SimpleStringProperty Subject;


        Data(String index, String Subject) {
            this.Index = new SimpleStringProperty(index);
            this.Subject= new SimpleStringProperty(Subject);
        }

        public String getFirstName() {
            return Index.get();
        }

        public void setFirstName(String fName) {
            Index.set(fName);
        }

        public String getLastName() {
            return Subject.get();
        }

        public void setLastName(String fName) {
            Subject.set(fName);
        }


}


