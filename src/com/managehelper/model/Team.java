package com.managehelper.model;

 public class Team {

     private double cost;
     private int participants;

     private double index;
     private double medianaPlus;
     private double medianaMinus;
     private double groupUnity;

     public double getIndex() {
         return index;
     }

     public void setIndex(double index) {
         this.index = index;
     }

     public double getMedianaPlus() {
         return medianaPlus;
     }

     public void setMedianaPlus(double medianaPlus) {
         this.medianaPlus = medianaPlus;
     }

     public double getMedianaMinus() {
         return medianaMinus;
     }

     public void setMedianaMinus(double medianaMinus) {
         this.medianaMinus = medianaMinus;
     }

     public double getGroupUnity() {
         return groupUnity;
     }

     public void setGroupUnity(double groupUnity) {
         this.groupUnity = groupUnity;
     }

     public double getCost() {
         return cost;
     }

     public void setCost(double cost) {
         this.cost = cost;
     }

     public int getParticipants() {
         return participants;
     }

     public void setParticipants(int participants) {
         this.participants = participants;
     }
 }
