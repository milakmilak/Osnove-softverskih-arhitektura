INSERT INTO ADMINISTRATOR(id, ime, is_blokiran, password, prezime, role, username)
VALUES (1, 'admin1', false, '$2y$10$L8Vc5JpyCcdd5QSL6IqCPOzLEjo8LJALjDgtw.r8dC012WYk0e872', 'admincevic', 'ROLE_ADMINISTRATOR', 'adminadmin');


INSERT INTO KUPAC(id, ime, is_blokiran, password, prezime, role, username, adresa)
VALUES (1, 'kupac', false, '$2y$10$nhaly4d0vC5ceJrQbvfcAu3tKFmV7N/55DypF7MrYKJ7dk83j7ttS', 'kupcevic', 'ROLE_KUPAC', 'kupackupac', 'kupacAdresa');


INSERT INTO PRODAVAC(id, ime, is_blokiran, password, prezime, role, username, adresa, email, naziv, posluje_od)
VALUES (1, 'prodavac', false, '$2y$10$bStLfg9.CG0m6wHoZc5y/eZDAJqd06xZoGXk.Zbvu5YE2oLs5djLO', 'prodavcevic', 'ROLE_PRODAVAC', 'prodavacprodavac', 'prodavacAdresa', 'prodavac@email.com', 'nazivProdavca', null);
