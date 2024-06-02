    package com.portalaluno.model;

    import jakarta.persistence.*;

    @Entity
    public class Student {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String name;
        private String email;

        @ManyToOne
        @JoinColumn(name = "courseid")
        private Course courseid;

        public Student(int id, String name, String email, Course courseid) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.courseid = courseid;
        }

        public Student(){
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {return email;}

        public void setEmail(String email) {
            this.email = email;
        }

        public Course getCourseId() {
            return courseid;
        }

        public void setCourseId(Course courseid) {
            this.courseid = courseid;
        }
    }
