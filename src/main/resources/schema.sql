-- Table des Auteurs
CREATE TABLE Auteurs (
    auteur_id INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    biographie TEXT
);

-- Table des Genres
CREATE TABLE Genres (
    genre_id INT PRIMARY KEY,
    nom VARCHAR(50)
);

-- Table des Livres
CREATE TABLE Livres (
                        livre_id INT PRIMARY KEY,
                        titre VARCHAR(255) NOT NULL,
                        auteur_id INT,
                        genre_id INT,
                        edition VARCHAR(50),
                        disponibilite BOOLEAN,
                        FOREIGN KEY (auteur_id) REFERENCES Auteurs(auteur_id),
                        FOREIGN KEY (genre_id) REFERENCES Genres(genre_id)
);

-- Table des Exemplaires
CREATE TABLE Exemplaires (
    exemplaire_id INT PRIMARY KEY,
    livre_id INT,
    statut VARCHAR(20),
    FOREIGN KEY (livre_id) REFERENCES Livres(livre_id)
);

-- Table des Utilisateurs
CREATE TABLE Utilisateurs (
    utilisateur_id INT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    adresse_email VARCHAR(255) UNIQUE,
    mot_de_passe_hashed VARCHAR(255),
    role VARCHAR(20)
);

-- Table des Emprunts
CREATE TABLE Emprunts (
    emprunt_id INT PRIMARY KEY,
    utilisateur_id INT,
    exemplaire_id INT,
    date_emprunt DATE NOT NULL,
    date_retour_prevue DATE,
    statut VARCHAR(20),
    FOREIGN KEY (utilisateur_id) REFERENCES Utilisateurs(utilisateur_id),
    FOREIGN KEY (exemplaire_id) REFERENCES Exemplaires(exemplaire_id)
);

-- Table des Réservations
CREATE TABLE Reservations (
    reservation_id INT PRIMARY KEY,
    utilisateur_id INT,
    livre_id INT,
    date_reservation DATE NOT NULL,
    statut VARCHAR(20),
    FOREIGN KEY (utilisateur_id) REFERENCES Utilisateurs(utilisateur_id),
    FOREIGN KEY (livre_id) REFERENCES Livres(livre_id)
);

-- Table des Commentaires
CREATE TABLE Commentaires (
    commentaire_id INT PRIMARY KEY,
    utilisateur_id INT,
    livre_id INT,
    contenu TEXT,
    date_commentaire DATE NOT NULL,
    note INT,
    FOREIGN KEY (utilisateur_id) REFERENCES Utilisateurs(utilisateur_id),
    FOREIGN KEY (livre_id) REFERENCES Livres(livre_id)
);
