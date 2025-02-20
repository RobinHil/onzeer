package com.mycompany.onzeer; // ONZEER main package

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;

import java.text.SimpleDateFormat;

import java.net.URL;

import java.awt.Container;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusListener;
import java.awt.event.FocusEvent;
import java.awt.Font;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Application main graphic window class
 * @author Robin HILAIRE
 */
public class Window extends JFrame
{
    /**
     * Application database management class
     */
    private final Database database;
    
    /**
     * Array which contains all the albums
     */
    private List<Album> albums;
    
    /**
     * Swing graphic list
     */
    private final JList<String> albumList;
    
    /**
     * Defines albumList methods components
     */
    private final DefaultListModel<String> listModel;
    
    /**
     * The panel where informations about the selected album are displayed
     */
    private final JPanel albumPanel;
    
    /**
     * The text field used to search an album
     */
    private final JTextField searchTextField;
    
    /**
     * The text field where the selected album title is displayed
     */
    private final JTextField titleTextField;
    
    /**
     * The text field where the selected album artist is displayed
     */
    private final JTextField artistTextField;
    
    /**
     * The text field where the selected album musical genre is displayed
     */
    private final JTextField musicalGenreTextField;
    
    /**
     * The text field where the selected album release date is displayed
     */
    private final JTextField dateTextField;
    
    /**
     * The text field where the selected album rating is displayed
     */
    private final JTextField ratingTextField;
    
    /**
     * The ComboBox where user can select by which element he will sort the list
     */
    private final JComboBox sortComboBox ;
    
    /**
     * The chackbox where user can choose between ascending and descending order sort
     */
    private final JCheckBox sortType;
    
    /**
     * Creates a new Window instance
     * @param _title Window title
     */
    public Window(String _title)
    {
        super(_title);
        
        URL url = getClass().getResource("/img/onzeerlogo.png");
        setIconImage(new ImageIcon(url).getImage());
        
        database = new Database(
                            "database_url", 
                            "database_port",
                            "database_password"
                              );
        
        albums = new ArrayList<>();
        albums = database.getAllAlbums();
        
        listModel = new DefaultListModel<>();
        albumList = new JList<>(listModel);
        
        albumPanel = new JPanel();
        
        titleTextField = new JTextField();
        artistTextField = new JTextField();
        musicalGenreTextField = new JTextField();
        dateTextField = new JTextField();
        ratingTextField = new JTextField();
        searchTextField = new JTextField();
        
        String[] sortStrings = { "ID (par défaut)", "Nom d'album", "Nom d'artiste", "Genre", "Date", "Note" };
        sortComboBox = new JComboBox(sortStrings);
        
        sortType = new JCheckBox("Tri décroissant");
                
        setListData();
        setWindowElements();
    }
    
    /**
     * Displays all albums data in listModel
     */
    private final void setListData()
    {
        listModel.clear();
        
        titleTextField.setText("");
        artistTextField.setText("");
        musicalGenreTextField.setText("");
        dateTextField.setText("");
        ratingTextField.setText("");
        
        // Ajout des éléments de l'ArrayList au modèle de liste
        for (Album album : albums)
            listModel.addElement(album.getTitle()+" - "+album.getId());
    }
    
    /**
     * Displays all parameter data in listModel
     * @param data The array which contains all the data to display
     */
    private void setListData(java.util.List<Album> data)
    {
        listModel.clear();
        
        titleTextField.setText("");
        artistTextField.setText("");
        musicalGenreTextField.setText("");
        dateTextField.setText("");
        ratingTextField.setText("");
        
        // Ajout des éléments de l'ArrayList au modèle de liste
        for (Album album : data)
            listModel.addElement(album.getTitle()+" - "+album.getId());
    }
    
    /**
     * Sets up all graphic window elements
     */
    private final void setWindowElements()
    {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        
        // Create JList and add a selection listener for JList
        albumList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        albumList.addListSelectionListener(e -> displayAlbumDetails());
        
        // Create JScrollPane for JList
        JScrollPane listScrollPane = new JScrollPane(albumList);

        // Create panel for displaying album details
        albumPanel.setLayout(new GridLayout(10, 1));
        albumPanel.setBackground(new Color(210, 210, 210));

        // Add components to content pane
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(listScrollPane, BorderLayout.WEST);
        contentPane.add(albumPanel, BorderLayout.CENTER);

        // Add buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        contentPane.add(buttonsPanel, BorderLayout.SOUTH);

        // Create "Ajouter" button
        JButton addButton = new JButton("Ajouter");
        addButton.addActionListener(e -> addAlbum());
        buttonsPanel.add(addButton);

        // Create "Supprimer" button
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.addActionListener(e -> deleteAlbum());
        buttonsPanel.add(deleteButton);
        
        // Create "Modifier" button
        JButton modifyButton = new JButton("Modifier");
        modifyButton.addActionListener(e -> modifyAlbum());
        buttonsPanel.add(modifyButton);
        
        
        // Create "Rechercher" text field
        searchTextField.addActionListener(e -> filterSearch());
        searchTextField.setPreferredSize(new Dimension(200,30));
        buttonsPanel.add(searchTextField);
        
        // Create the ComboBox to sort element
        sortComboBox.addActionListener(e-> sortByComboBox());
        buttonsPanel.add(sortComboBox);
        
        // Create the sort type checkbox
        sortType.addActionListener(e-> sortByComboBox());
        buttonsPanel.add(sortType);
        
        // Create refresh Button
        JButton refreshButton = new JButton("Actualiser");
        refreshButton.addActionListener (e->refreshAlbum());
        buttonsPanel.add(refreshButton);
        
        // Set placeholder text for "Rechercher" text field
        searchTextField.setForeground(Color.GRAY);
        searchTextField.setText(" Rechercher");
        searchTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e)
            {
                if (searchTextField.getText().equals(" Rechercher"))
                {
                    searchTextField.setText("");
                    searchTextField.setForeground(Color.WHITE);
                }
            }
            @Override
            public void focusLost(FocusEvent e)
            {
                if (searchTextField.getText().isEmpty())
                {
                    searchTextField.setForeground(Color.GRAY);
                    searchTextField.setText(" Rechercher");
                }
            }
        });
        
        Font textFieldsFont = new Font("Arial", Font.PLAIN, 17);
        
        // Add album title text field
        JLabel albumLabel = createLabel("  Album");
        albumLabel.setForeground(Color.WHITE);
        titleTextField.setFont(textFieldsFont);
        titleTextField.setBackground(Color.GRAY);
        titleTextField.setForeground(new Color(230,230,230));
        albumPanel.add(albumLabel);
        albumPanel.add(titleTextField);
        albumPanel.setBackground(new Color(61, 64,66));
        
        // Add album artist text field
        JLabel artistLabel = createLabel("  Artiste");
        artistLabel.setForeground(Color.WHITE);
        artistTextField.setFont(textFieldsFont);
        artistTextField.setBackground(Color.GRAY);
        artistTextField.setForeground(new Color(230,230,230));
        albumPanel.add(artistLabel);
        albumPanel.add(artistTextField);
        
        // Add album musical genre text field
        JLabel genreLabel = createLabel("  Genre musical");
        genreLabel.setForeground(Color.WHITE);
        musicalGenreTextField.setFont(textFieldsFont);
        musicalGenreTextField.setBackground(Color.GRAY);
        musicalGenreTextField.setForeground(new Color(230,230,230));
        albumPanel.add(genreLabel);
        albumPanel.add(musicalGenreTextField);
        
        // Add album date text field
        JLabel dateLabel = createLabel("  Date (\"dd/MM/yyyy\")");
        dateLabel.setForeground(Color.WHITE);
        dateTextField.setFont(textFieldsFont);
        dateTextField.setBackground(Color.GRAY);
        dateTextField.setForeground(new Color(230,230,230));
        albumPanel.add(dateLabel);
        albumPanel.add(dateTextField);
        
        JLabel noteLabel = createLabel("  Note (/5)");
        noteLabel.setForeground(Color.WHITE);
        ratingTextField.setFont(textFieldsFont);
        ratingTextField.setBackground(Color.GRAY);
        ratingTextField.setForeground(new Color(230,230,230));
        albumPanel.add(noteLabel);
        albumPanel.add(ratingTextField);
    }
    
    /**
     * Album search function
     */
    private void filterSearch()
    {
        String text = searchTextField.getText().toLowerCase();
        if(text.length()>0)
        {
            java.util.List<Album> results = new ArrayList<>();
            for(Album album : albums)
                    if (
                        (album.getTitle().toLowerCase()+" - "+Integer.toString(album.getId())).contains(text) ||
                        album.getArtist().toLowerCase().contains(text) ||
                        new SimpleDateFormat("dd/MM/yyyy").format(album.getDate()).contains(text) || 
                        album.getMusicalGenre().toLowerCase().contains(text) ||
                        Float.toString(album.getRating()).contains(text)
                       )
                        results.add(album);
            setListData(results);
        }
        else
            setListData();
    }

    /**
     * Displays all selected album details
     */
    private void displayAlbumDetails()
    {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        int selectedIndex = albumList.getSelectedIndex();
        if (selectedIndex != -1)
        {
            String selectedItem = albumList.getSelectedValue();
            int albumId = Integer.parseInt(selectedItem.substring(selectedItem.lastIndexOf(" - ") + 3));
            for (Album album : albums)
                if (albumId == album.getId())
                {
                    // Update the panel with new details
                    titleTextField.setText(album.getTitle());
                    artistTextField.setText(album.getArtist());
                    musicalGenreTextField.setText(album.getMusicalGenre());
                    dateTextField.setText(new SimpleDateFormat("dd/MM/yyyy").format(album.getDate()));
                    ratingTextField.setText(Float.toString(album.getRating()));
                }
        }
        setCursor(Cursor.getDefaultCursor());
    }
    
    /**
     * Refreshes the album list with recent data
     */
    private void refreshAlbum()
    {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        albums = database.getAllAlbums();
        setListData();
        setCursor(Cursor.getDefaultCursor());
    }
    
    /**
     * Creates a custom JLabel
     * @param text JLabel text to set
     * @return A custom JLabel
     */
    private JLabel createLabel(String text)
    {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        return label;
    }

    /**
     * Album adding function
     */
    private void addAlbum()
    {
        String dialogTitle = "Ajout d'un album";
        
        String newTitle = JOptionPane.showInputDialog(this, "Entrez le nom du nouvel album", dialogTitle, JOptionPane.QUESTION_MESSAGE);
        if (newTitle == null)
            return ;
        
        String newArtist = JOptionPane.showInputDialog(this, "Entrez l'artiste du nouvel album", dialogTitle, JOptionPane.QUESTION_MESSAGE);
        if (newArtist == null)
            return ;
        
        String newMusicalGenre = JOptionPane.showInputDialog(this, "Entrez le genre musical du nouvel album", dialogTitle, JOptionPane.QUESTION_MESSAGE);
        if (newMusicalGenre == null)
            return ;
        
        Date newDate = null;
        boolean successDate = false;
        while (!successDate)
        {
            String strNewDate = JOptionPane.showInputDialog(this, "Entrez la date de sortie du nouvel album (format \"dd/MM/yyyy\")", dialogTitle, JOptionPane.QUESTION_MESSAGE);
            if (strNewDate == null)
                return ;
            try {
                newDate = new SimpleDateFormat("dd/MM/yyyy").parse(strNewDate);
                successDate = true;
            } catch (Exception e) {
                successDate = false;
            }
        }
        
        float newRating = 0;
        boolean successRating = false;
        while (!successRating || newRating > 5 || newRating < 0)
        {
            String strNewRating = JOptionPane.showInputDialog(this, "Entrez la note du nouvel album /5 (format \"x.y\")", dialogTitle, JOptionPane.QUESTION_MESSAGE);
            if (strNewRating == null)
                return ;
            if (strNewRating.compareTo("") == 0)
                break;
            try {
                newRating = Float.parseFloat(strNewRating);
                successRating = true;
            } catch (Exception e) {
                successRating = false;
            }
            if (strNewRating.length() > 3)
                successRating = false;
        }
        
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        database.addAlbum(newTitle, newArtist, newMusicalGenre, newDate, newRating);
        albums = database.getAllAlbums();
        setListData();
        setCursor(Cursor.getDefaultCursor());
        JOptionPane.showMessageDialog(this, "Album ajouté avec succès !", "Ajout", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Album deletion function
     */
    private void deleteAlbum()
    {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        int selectedIndex = albumList.getSelectedIndex();
        if (selectedIndex != -1)
        {
            String selectedItem = listModel.get(selectedIndex);
            int albumId = Integer.parseInt(selectedItem.substring(selectedItem.lastIndexOf(" - ") + 3));
            database.deleteAlbum(albumId);
            albums.remove(selectedIndex);
            setListData();
            JOptionPane.showMessageDialog(this, "Album supprimé avec succès !", "Suppression", JOptionPane.INFORMATION_MESSAGE);
        }
        setCursor(Cursor.getDefaultCursor());
    }
    
    /**
     * Album modification function
     */
    private void modifyAlbum()
    {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        int selectedIndex = albumList.getSelectedIndex();
        if (selectedIndex != -1)
        {
            String selectedItem = listModel.get(selectedIndex);
            int albumId = Integer.parseInt(selectedItem.substring(selectedItem.lastIndexOf(" - ") + 3));
            
            String newTitle = titleTextField.getText();
            if (newTitle.compareTo("") == 0) {
                setCursor(Cursor.getDefaultCursor());
                JOptionPane.showMessageDialog(this, "Veuillez entrer un titre d'album.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return ;
            }

            String newArtist = artistTextField.getText();
            if (newArtist.compareTo("") == 0) {
                setCursor(Cursor.getDefaultCursor());
                JOptionPane.showMessageDialog(this, "Veuillez entrer un nom d'artiste.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return ;
            }

            String newMusicalGenre = musicalGenreTextField.getText();
            if (newMusicalGenre.compareTo("") == 0) {
                setCursor(Cursor.getDefaultCursor());
                JOptionPane.showMessageDialog(this, "Veuillez entrer un genre musical.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return ;
            }

            String strNewDate = dateTextField.getText();
            if (strNewDate.compareTo("") == 0) {
                setCursor(Cursor.getDefaultCursor());
                JOptionPane.showMessageDialog(this, "Veuillez entrer une date valide au format \"dd/MM/yyyy\".", "Erreur", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            Date newDate;
            try {
                newDate = new SimpleDateFormat("dd/MM/yyyy").parse(strNewDate);
            } catch (Exception e) {
                setCursor(Cursor.getDefaultCursor());
                JOptionPane.showMessageDialog(this, "Veuillez entrer une date valide au format \"dd/MM/yyyy\".", "Erreur", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            
            String strNewRating = ratingTextField.getText();
            if (strNewRating.length() > 3) {
                setCursor(Cursor.getDefaultCursor());
                JOptionPane.showMessageDialog(this, "Veuillez entrer une note valide /5 avec une seule décimale (format \"x.y\").", "Erreur", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            float newRating = 0;
            if (strNewRating.compareTo("") != 0)
            {
                try {
                    newRating = Float.parseFloat(strNewRating);
                } catch (Exception e) {
                    setCursor(Cursor.getDefaultCursor());
                    JOptionPane.showMessageDialog(this, "Veuillez entrer une note valide /5 (format \"x.y\").", "Erreur", JOptionPane.ERROR_MESSAGE);
                    return ;
                }
            }
            if (newRating > 5 || newRating < 0) {
                setCursor(Cursor.getDefaultCursor());
                JOptionPane.showMessageDialog(this, "Veuillez entrer une note valide /5 (format \"x.y\").", "Erreur", JOptionPane.ERROR_MESSAGE);
                return ;
            }
            
            for (Album album : albums)
                if (album.getId() == albumId)
                    if (
                        album.getTitle().compareTo(newTitle) != 0 ||
                        album.getArtist().compareTo(newArtist) != 0 ||
                        album.getMusicalGenre().compareTo(newMusicalGenre) != 0 ||
                        album.getDate().compareTo(newDate) != 0 ||
                        album.getRating() != newRating
                       )
                    {
                        database.updateAlbum(albumId, newTitle, newArtist, newMusicalGenre, newDate, newRating);
                        albums = database.getAllAlbums();
                        setListData();
                    }
        }
        setCursor(Cursor.getDefaultCursor());
    }
    
    /**
     * Album sort function
     */
    private void sortByComboBox()
    {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(!sortType.isSelected())
            switch (sortComboBox.getSelectedItem().toString())
            {
                case "ID (par défaut)":
                    Collections.sort(albums, Comparator.comparing(Album::getId));
                    setListData();
                    break;
                case "Nom d'album":
                    Collections.sort(albums, Comparator.comparing(Album::getTitle));
                    setListData();
                    break;
                case "Nom d'artiste":
                    Collections.sort(albums, Comparator.comparing(Album::getArtist));
                    setListData();
                    break;
                case "Genre":
                    Collections.sort(albums, Comparator.comparing(Album::getMusicalGenre));
                    setListData();
                    break;
                case "Date":
                    Collections.sort(albums, Comparator.comparing(Album::getDate));
                    setListData();
                    break;
                case "Note":
                    Collections.sort(albums, Comparator.comparing(Album::getRating));
                    setListData();
                    break;
                default:
                    break;
            }
        else
            switch (sortComboBox.getSelectedItem().toString())
            {
                case "ID (par défaut)":
                    Collections.sort(albums, Comparator.comparing(Album::getId).reversed());
                    setListData();
                    break;
                case "Nom d'album":
                    Collections.sort(albums, Comparator.comparing(Album::getTitle).reversed());
                    setListData();
                    break;
                case "Nom d'artiste":
                    Collections.sort(albums, Comparator.comparing(Album::getArtist).reversed());
                    setListData();
                    break;
                case "Genre":
                    Collections.sort(albums, Comparator.comparing(Album::getMusicalGenre).reversed());
                    setListData();
                    break;
                case "Date":
                    Collections.sort(albums, Comparator.comparing(Album::getDate).reversed());
                    setListData();
                    break;
                case "Note":
                    Collections.sort(albums, Comparator.comparing(Album::getRating).reversed());
                    setListData();
                    break;
                default:
                    break;
            }
        setCursor(Cursor.getDefaultCursor());
    }  
}

    
