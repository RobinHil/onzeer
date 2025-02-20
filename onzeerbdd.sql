-- phpMyAdmin SQL Dump
-- version 5.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onzeerbdd`
--

-- --------------------------------------------------------

--
-- Table structure for table `Album`
--

CREATE TABLE `Album` (
  `id_album` bigint(20) UNSIGNED NOT NULL,
  `album_title` varchar(100) NOT NULL,
  `artist_name` varchar(100) NOT NULL,
  `release_date` date NOT NULL,
  `music_genre` varchar(50) NOT NULL,
  `album_rating` decimal(2,1) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Album`
--

INSERT INTO `Album` (`id_album`, `album_title`, `artist_name`, `release_date`, `music_genre`, `album_rating`) VALUES
(35, 'In Utero', 'Nirvana', '1313-12-11', 'Grunge', 5.0),
(36, 'Civilisation', 'Orelsan', '2022-09-27', 'Rap', 0.0),
(41, 'The Sound of Silence', 'John Doe', '2022-01-01', 'Rock', 4.5),
(42, 'A World Without You', 'Jane Smith', '2022-02-15', 'Pop', 3.8),
(43, 'Urban Rhythms', 'Bob Johnson', '2022-03-20', 'Hip-Hop', 4.2),
(44, 'Smooth Jazz Nights', 'Alice Brown', '2022-04-10', 'Jazz', 3.9),
(45, 'Country Roads', 'Charlie Davis', '2022-05-05', 'Country', 4.1),
(46, 'Bluesy Tunes', 'Eva White', '2022-06-18', 'Blues', 3.7),
(47, 'R&B Grooves', 'Frank Green', '2022-07-22', 'R&B', 4.0),
(48, 'Electronic Odyssey', 'Grace Black', '2022-08-30', 'Electronic', 4.3),
(50, 'Folk Stories', 'Ivy Gray', '2022-10-25', 'Folk', 3.6),
(52, 'Pop Dreams', 'Jane Smith', '2022-12-04', 'Pop', 3.9),
(53, 'Hip-Hop Evolution', 'Bob Johnson', '2023-01-08', 'Hip-Hop', 4.1),
(54, 'Jazz Reflections', 'Alice Brown', '2023-02-14', 'Jazz', 3.8),
(56, 'Blues Essence', 'Eva White', '2023-04-25', 'Blues', 4.4),
(57, 'R&B Vibes', 'Frank Green', '2023-05-30', 'R&B', 3.7),
(58, 'Electronic Escapade', 'Grace Black', '2023-06-15', 'Electronic', 3.9),
(59, 'Classical Harmony', 'Henry Taylor', '2023-07-20', 'Classical', 4.2),
(60, 'Folk Journeys', 'Ivy Gray', '2023-08-28', 'Folk', 4.6),
(61, 'Rock Resonance', 'John Doe', '2023-09-10', 'Rock', 4.0),
(62, 'Pop Melodies', 'Jane Smith', '2023-10-12', 'Pop', 3.6),
(63, 'Hip-Hop Fusion', 'Bob Johnson', '2023-11-15', 'Hip-Hop', 4.3),
(64, 'Jazz Meditations', 'Alice Brown', '2023-12-20', 'Jazz', 3.8),
(65, 'Country Bliss', 'Charlie Davis', '2024-01-05', 'Country', 4.1),
(66, 'zouz', 'Ziak', '1111-12-12', 'Metal', 2.0),
(67, 'La fleur du mal', 'Lomepal', '2020-11-11', 'Rap', 0.0),
(68, 'Lost in the Echo', 'Mike Johnson', '2022-01-01', 'Alternative Rock', 4.5),
(69, 'Dance Revolution', 'Sophie Thompson', '2022-02-15', 'Electronic', 3.8),
(70, 'City Lights', 'Carlos Rodriguez', '2022-03-20', 'Pop', 4.2),
(71, 'Jazz Fusion Spectacle', 'Olivia White', '2022-04-10', 'Jazz Fusion', 3.9),
(72, 'Country Heartstrings', 'Natalie Martin', '2022-05-05', 'Country', 4.1),
(73, 'Blues Explosion', 'Isaac Davis', '2022-06-18', 'Blues', 3.7),
(74, 'Soulful Rhythms', 'Emily Baker', '2022-07-22', 'Soul', 4.0),
(75, 'Trance Voyager', 'David Green', '2022-08-30', 'Trance', 4.3),
(76, 'Classical Elegance', 'Sophia Taylor', '2022-09-12', 'Classical', 4.5),
(77, 'Folk Tales', 'Liam Anderson', '2022-10-25', 'Folk', 3.6),
(78, 'Echoes of Metal', 'Emma Gray', '2022-11-11', 'Metal', 0.0),
(79, 'Indie Dreams', 'Jack White', '2022-12-04', 'Indie', 3.9),
(80, 'Rap Revolution', 'Alex Carter', '2023-01-08', 'Rap', 4.1),
(81, 'Smooth Jazz Lounge', 'Mia Brown', '2023-02-14', 'Smooth Jazz', 3.8),
(83, 'Electro Swing Party', 'Sophie Baker', '2023-04-25', 'Electro Swing', 4.4),
(84, 'Reggae Vibes', 'Lucas Davis', '2023-05-30', 'Reggae', 3.7),
(85, 'Ambient Dreams', 'Ava Garcia', '2023-06-15', 'Ambient', 3.9),
(86, 'Opera Extravaganza', 'Ethan Adams', '2023-07-20', 'Opera', 4.2),
(87, 'Acoustic Journeys', 'Olivia Gray', '2023-08-28', 'Acoustic', 4.6),
(89, 'Ska Fiesta', 'Sophie Thompson', '2023-10-12', 'Ska', 3.6),
(90, 'Trap Beats', 'Mason Wright', '2023-11-15', 'Trap', 4.3),
(91, 'Latin Grooves', 'Sophia Rodriguez', '2023-12-20', 'Latin', 3.8),
(92, 'Jazz Lounge', 'Leo Garcia', '2024-01-05', 'Jazz', 4.1),
(94, 'beat it', 'michael jackson', '1992-11-12', 'rock', 3.0),
(95, 'Alors regarde', 'Patrick Bruel', '1990-02-02', 'Variété', 5.0),
(97, 'TEST2', 'ARtiste', '2000-01-27', 'Pop', 3.0);

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE `artist` (
  `artist_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`artist_name`) VALUES
('Alex Carter'),
('Alice Brown'),
('ARtiste'),
('Ava Garcia'),
('Bob Johnson'),
('Carlos Rodriguez'),
('Charlie Davis'),
('David Green'),
('Emily Baker'),
('Emma Gray'),
('Ethan Adams'),
('Eva White'),
('Frank Green'),
('Grace Black'),
('Henry Taylor'),
('Isaac Davis'),
('Ivy Gray'),
('Jack White'),
('Jane Smith'),
('John Doe'),
('Leo Garcia'),
('Liam Anderson'),
('Lomepal'),
('Lucas Davis'),
('Mason Wright'),
('Mia Brown'),
('michael jackson'),
('Mike Johnson'),
('Natalie Martin'),
('Nirvana'),
('Olivia Gray'),
('Olivia White'),
('Orelsan'),
('Patrick Bruel'),
('Sophia Rodriguez'),
('Sophia Taylor'),
('Sophie Baker'),
('Sophie Thompson'),
('Ziak');

-- --------------------------------------------------------

--
-- Table structure for table `genre`
--

CREATE TABLE `genre` (
  `music_genre` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `genre`
--

INSERT INTO `genre` (`music_genre`) VALUES
('Acoustic'),
('Alternative Rock'),
('Ambient'),
('Blues'),
('Classical'),
('Country'),
('Electro Swing'),
('Electronic'),
('Folk'),
('Grunge'),
('Hip-Hop'),
('Indie'),
('Jazz'),
('Jazz Fusion'),
('Latin'),
('Metal'),
('Opera'),
('Pop'),
('R&B'),
('Rap'),
('Reggae'),
('Rock'),
('Ska'),
('Smooth Jazz'),
('Soul'),
('Trance'),
('Trap'),
('Variété');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Album`
--
ALTER TABLE `Album`
  ADD PRIMARY KEY (`id_album`),
  ADD KEY `Album_gm_fk` (`music_genre`),
  ADD KEY `Album_an_fk` (`artist_name`);

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`artist_name`);

--
-- Indexes for table `genre`
--
ALTER TABLE `genre`
  ADD PRIMARY KEY (`music_genre`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Album`
--
ALTER TABLE `Album`
  MODIFY `id_album` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Album`
--
ALTER TABLE `Album`
  ADD CONSTRAINT `Album_an_fk` FOREIGN KEY (`artist_name`) REFERENCES `artist` (`artist_name`),
  ADD CONSTRAINT `Album_gm_fk` FOREIGN KEY (`music_genre`) REFERENCES `genre` (`music_genre`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
