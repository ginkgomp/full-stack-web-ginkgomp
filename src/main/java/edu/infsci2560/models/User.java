package edu.infsci2560.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
*
* @author Wenwen Sun
*/
@Entity
public class User {

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   protected Long id;
   protected String name;
   protected String intro;
   protected String icon;



   public User() {
       this.id = Long.MAX_VALUE;
       this.name = null;
       this.intro = null;
       this.icon = null;
   }

   
   public User(Long id, String name, String intro, String icon) {
	this.id = id;
	this.name = name;
	this.intro = intro;
	this.icon = icon;
}


   @Override
   public String toString() {
       return "[ id=" + this.id + ", name=" + this.name + ", intro=" + this.intro +  ", icon=" + this.icon + " ]";
      
   }

   @Override
   public boolean equals(Object other) {
       return EqualsBuilder.reflectionEquals(this, other);
   }

   @Override
   public int hashCode() {
       return HashCodeBuilder.reflectionHashCode(this);
   }

   /**
    * @return the name
    */
   public String getName() {
       return name;
   }

   /**
    * @param name the name to set
    */
   public void setName(String name) {
       this.name = name;
   }

   /**
    * @return the intro
    */
   public String getIntro() {
       return intro;
   }

   /**
    * @param intro the intro to set
    */
   public void setIntro(String intro) {
       this.intro = intro;
   }

   /**
    * @return the id
    */
   public Long getId() {
       return id;
   }

   /**
    * @param id the id to set
    */
   public void setId(Long id) {
       this.id = id;
   }


   /**
    * @return the icon
    */
   public String getIcon() {
       return icon;
   }

   /**
    * @param icon the icon to set
    */
   public void setIcon(String icon) {
       this.icon = icon;
   }

}
