package com.example.uptenfermeria.models;

import java.util.List;

public class Waqi {
   private String status;
   private WaqiData data;

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

   public WaqiData getData() {
      return data;
   }

   public void setData(WaqiData data) {
      this.data = data;
   }
}
