-- Insertion de données dans la table Auteurs
INSERT INTO Auteurs (auteur_id, nom, prenom, biographie)
VALUES
    (1, 'Doe', 'John', 'Auteur renommé avec de nombreuses œuvres publiées.'),
    (2, 'Smith', 'Jane', 'Écrivaine primée et célèbre pour ses romans captivants.');

-- Insertion de données dans la table Genres
INSERT INTO Genres (genre_id, nom)
VALUES
    (1, 'Roman'),
    (2, 'Science-fiction'),
    (3, 'Thriller');

-- Insertion de données dans la table Livres
INSERT INTO Livres (livre_id, titre, auteur_id, genre_id, edition, disponibilite)
VALUES
    (1, 'Étranger', 1, 1, 'Édition XYZ', true),
    (2, 'Le Guide du voyageur galactique', 2, 2, 'Édition ABC', true),
    (3, 'Gone Girl', 1, 3, 'Édition 123', false);

-- Insertion de données dans la table Exemplaires
INSERT INTO Exemplaires (exemplaire_id, livre_id, statut)
VALUES
    (1, 1, 'Disponible'),
    (2, 1, 'Emprunté'),
    (3, 2, 'Disponible'),
    (4, 2, 'Reservé'),
    (5, 3, 'Disponible');

-- Insertion de données dans la table Utilisateurs
INSERT INTO Utilisateurs (utilisateur_id, nom, prenom, adresse_email, mot_de_passe_hashed, role)
VALUES
    (1, 'Dupont', 'Alice', 'alice@example.com', 'hashed_password', 'Utilisateur'),
    (2, 'Martin', 'Bob', 'bob@example.com', 'hashed_password', 'Bibliothecaire');

-- Insertion de données dans la table Emprunts
INSERT INTO Emprunts (emprunt_id, utilisateur_id, exemplaire_id, date_emprunt, date_retour_prevue, statut)
VALUES
    (1, 1, 1, '2024-02-01', '2024-02-15', 'En cours'),
    (2, 1, 2, '2024-02-10', '2024-02-25', 'En cours'),
    (3, 2, 3, '2024-02-05', '2024-02-20', 'Terminé');

-- Insertion de données dans la table Reservations
INSERT INTO Reservations (reservation_id, utilisateur_id, livre_id, date_reservation, statut)
VALUES
    (1, 1, 3, '2024-02-15', 'En attente'),
    (2, 2, 1, '2024-02-12', 'Prêt à être récupéré');

-- Insertion de données dans la table Commentaires
INSERT INTO Commentaires (commentaire_id, utilisateur_id, livre_id, contenu, date_commentaire, note)
VALUES
    (1, 1, 1, 'Un très bon livre!', '2024-02-10', 5),
    (2, 2, 2, 'Une lecture fascinante.', '2024-02-18', 4);
