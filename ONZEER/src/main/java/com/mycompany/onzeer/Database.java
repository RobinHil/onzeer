package com.mycompany.onzeer; // ONZEER main package

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java.sql.*;

/**
 * Database management class
 * @author Simon MILLET
 */
public class Database
{    
    /**
     * Database url
     */
    private final String url;
    
    /**
     * Database username
     */
    private final String username;
    
    /**
     * Database user password
     */
    private final String password;

    /**
     * Creates a new Database class instance
     * @param _url Database url
     * @param _username Database username
     * @param _password Database user password
     */
    public Database(String _url, String _username, String _password)
    {
        url = _url;
        username = _username;
        password = _password;
    }
    
    /**
     * Fetches all albums from the database
     * @return An array which contains all albums
     */
    public List<Album> getAllAlbums()
    {
        List<Album> albumsList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sqlQuery = "SELECT\n" + //
                                    "id_album,\n" + //
                                    "album_title,\n" + //
                                    "artist_name,\n" + //
                                    "release_date,\n" + //
                                    "music_genre,\n" + //
                                    "album_rating\n" + //
                              "FROM Album\n;";
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                int albumId = resultSet.getInt("id_album");
                String albumTitle = resultSet.getString("album_title");
                String artistName = resultSet.getString("artist_name");
                java.sql.Date SQLreleaseDate = resultSet.getDate("release_date");
                java.util.Date releaseDate = new java.util.Date(SQLreleaseDate.getTime());
                String albumGenre = resultSet.getString("music_genre");
                float albumRating = resultSet.getFloat("album_rating");
                Album album = new Album(albumTitle, albumId , artistName, albumGenre, releaseDate, albumRating);
                albumsList.add(album);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return albumsList;
    }
    
    /**
     * Adds a new album to the database
     * @param _title The new album title
     * @param _artist The new album artist
     * @param _musicalGenre The new album musical genre
     * @param _date The new album release date
     * @param _rating The new album rating
     */
    public void addAlbum(String _title, String _artist, String _musicalGenre, java.util.Date _date, float _rating)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            
            String sql = "INSERT IGNORE INTO artist (artist_name) VALUES (\""+_artist+"\");";
            statement.executeUpdate(sql);
            
            sql = "INSERT IGNORE INTO genre (music_genre) VALUES (\""+_musicalGenre+"\");";
            statement.executeUpdate(sql);
            
            sql = "INSERT INTO Album (" + //
                            "album_title, " + //
                            "artist_name, " + //
                            "release_date, " + //
                            "music_genre, " + //
                            "album_rating) " + //
                       "VALUES (\"" + //
                            _title + "\", \"" + //
                            _artist + "\", \"" + //
                            new java.sql.Date(_date.getTime()) + "\", \"" + //
                            _musicalGenre + "\"," + //
                            _rating + ")" + //
                       ";";
            statement.executeUpdate(sql);
            
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Deletes an album from the database
     * @param _albumId The id of the album to delete
     */
    public void deleteAlbum(int _albumId)
    {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            
            String sql = "DELETE FROM Album WHERE id_album = " + _albumId;
            statement.executeUpdate(sql);
            
            sql = "DELETE FROM genre WHERE music_genre NOT IN (SELECT music_genre FROM Album);";
            statement.executeUpdate(sql);
            
            sql = "DELETE FROM artist WHERE artist_name NOT IN (SELECT artist_name FROM Album);";
            statement.executeUpdate(sql);
            
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Updates an album informations in the database
     * @param _id The id of the album to modify
     * @param _title The new title of the album
     * @param _artist The new artist of the album
     * @param _musicalGenre The new musical genre of the album
     * @param _date The new date of the album
     * @param _rating The new rating of the album
     */
    public void updateAlbum(int _id, String _title, String _artist, String _musicalGenre, java.util.Date _date, float _rating)
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            
            String sql = "INSERT IGNORE INTO artist (artist_name) VALUES (\""+_artist+"\");";
            statement.executeUpdate(sql);
            
            sql = "INSERT IGNORE INTO genre (music_genre) VALUES (\""+_musicalGenre+"\");";
            statement.executeUpdate(sql);
            
            sql = "UPDATE Album SET " + //
                            "album_title = \"" + _title +"\", " + //
                            "artist_name = \"" + _artist +"\", " + //
                            "release_date = \"" + new java.sql.Date(_date.getTime()) +"\", " + //
                            "music_genre = \"" + _musicalGenre +"\", " + //
                            "album_rating = " + _rating + //
                       " WHERE " + //
                            "id_album = " + _id + //
                       ";";
            statement.executeUpdate(sql);
            
            sql = "DELETE FROM genre WHERE music_genre NOT IN (SELECT music_genre FROM Album);";
            statement.executeUpdate(sql);
            
            sql = "DELETE FROM artist WHERE artist_name NOT IN (SELECT artist_name FROM Album);";
            statement.executeUpdate(sql);
            
            statement.close();
            connection.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
