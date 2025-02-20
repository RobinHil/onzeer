package com.mycompany.onzeer; // ONZEER main package

/**
 * Album data storage class
 * @author Robin HILAIRE
 */
public class Album
{
    /**
     * Album id
     */
    private int id;
    
    /**
     * Album title
     */
    private String title;
   
    /**
     * Album artist
     */
    private String artist;
    
    /**
     * Album musical genre
     */
    private String musicalGenre;
    
    /**
     * Album release date
     */
    private java.util.Date date;
    
    /**
     * Album rating
     */
    private float rating;
            
    /**
     * Creates a new Album instance
     * @param _id Album id
     * @param _title Album title
     * @param _artist Album artist
     * @param _musicalGenre Album musical genre
     * @param _date Album release date
     * @param _rating Album rating
     */
    public Album(String _title, int _id, String _artist, String _musicalGenre, java.util.Date _date, float _rating) 
    {
        
        title = _title;
        id = _id;
        artist = _artist;
        musicalGenre = _musicalGenre;
        date = _date;
        rating = _rating;
    }
    
    /**
     * Album id getter
     * @return The current album id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Album id setter
     * @param _id The new album id to set
     */
    public void setId(int _id)
    {
        id = _id;
    }
    
    /**
     * Album title getter
     * @return The current album title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Album title setter
     * @param _title The new album title to set
     */
    public void setTitle(String _title)
    {
        title = _title;
    }
    
    /**
     * Album artist getter
     * @return The current album artist
     */
    public String getArtist()
    {
        return artist;
    }

    /**
     * Album artist setter
     * @param _artist The new album artist to set
     */
    public void setArtist(String _artist)
    {
        artist = _artist;
    }
    
    /**
     * Album musical genre getter
     * @return The current album musical genre
     */
    public String getMusicalGenre()
    {
        return musicalGenre;
    }

    /**
     * Album musical genre setter
     * @param _musicalGenre The new album musical genre to set
     */
    public void setMusicalGenre(String _musicalGenre)
    {
        musicalGenre = _musicalGenre;
    }
    
    /**
     * Album release date getter
     * @return The current album release date
     */
    public java.util.Date getDate()
    {
        return date;
    }

    /**
     * Album release date setter
     * @param _date The new album release date to set
     */
    public void setDate(java.sql.Date _date)
    {
        date = _date;
    }
    
    /**
     * Album rating getter
     * @return The current album rating
     */
    public float getRating()
    {
        return rating;
    }

    /**
     * Album rating setter
     * @param _rating The new album rating to set
     */
    public void setRating(float _rating)
    {
        rating = _rating;
    }
}
