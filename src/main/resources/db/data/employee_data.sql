INSERT INTO poc.optical_store
(name, address, additional_address, city)
VALUES
('Optical center', '15 rue du haut', null, 'Nantes'),
('Alain Afflelou', '24 rue à gauche', 'Centre commercial toto', 'St Luce sur loire'),
('General optique', '33 avenue LeGrand', null, 'Nantes');

INSERT INTO poc.employee 
(first_name, last_name, optical_store) 
VALUES
('Jean', 'Moulin', 1),
('Bob', 'Morane', 1),
('Pierre', 'Marron', 2),
('Jean', 'Pupile', 3),
('Marie', 'Gilger', 3),
('Oceanne', 'Tilier', 3);

