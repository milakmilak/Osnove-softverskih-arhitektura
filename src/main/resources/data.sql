INSERT INTO ADMINISTRATOR(ID, IME, IS_BLOKIRAN, PASSWORD, PREZIME, ROLE, USERNAME)
VALUES (1, 'admin1', false, '$2y$10$L8Vc5JpyCcdd5QSL6IqCPOzLEjo8LJALjDgtw.r8dC012WYk0e872', 'admincevic', 'ROLE_ADMINISTRATOR', 'adminadmin');


INSERT INTO KUPAC(ID, IME, IS_BLOKIRAN, PASSWORD, PREZIME, ROLE, USERNAME, ADRESA)
VALUES (1, 'kupac', false, '$2y$10$nhaly4d0vC5ceJrQbvfcAu3tKFmV7N/55DypF7MrYKJ7dk83j7ttS', 'kupcevic', 'ROLE_KUPAC', 'kupackupac', 'kupacAdresa');


INSERT INTO PRODAVAC(ID, IME, IS_BLOKIRAN, PASSWORD, PREZIME, ROLE, USERNAME, ADRESA, EMAIL, NAZIV, POSLUJE_OD)
VALUES (1, 'prodavac', false, '$2y$10$bStLfg9.CG0m6wHoZc5y/eZDAJqd06xZoGXk.Zbvu5YE2oLs5djLO', 'prodavcevic', 'ROLE_PRODAVAC', 'prodavacprodavac', 'prodavacAdresa', 'prodavac@email.com', 'nazivProdavca', null);


INSERT INTO ARTIKAL(ID, CENA, NAZIV, OPIS, PUTANJA_SLIKE, PRODAVAC_ID)
VALUES (1, 20000, 'Usisivac', 'Skupljac prasine na struju za vas dom', null, 1),
       (2, 3000, 'Fen', 'Osusivac za vasu kosu', null, 1),
       (3, 50000, 'iPhone X', 'Telefon mobilnga tipa', null, 1),
       (4, 80000, 'Laptop kompjuter', 'Prenosni racunar za ljude u pokretu', null, 1),
       (5, 18000, 'Nike AirMax 90', 'Patike za ljude koji se loze na juzni vetar', null, 1),
       (6, 1500, 'HDMI kabal', 'Kabal da spojite dva uredjaja koji imaju hdmi portove', null, 1),
       (7, 50, 'VodaVoda', 'Voda najobicnija od 1L', null, 1),
       (8, 150, 'Hemijska olovka', 'Hemijska olovka koja je tu vas kada vam je najpotrebnija', null, 1),
       (9, 250000, 'Fiat punto', 'Registrovan do jeseni, trap utegnut, NOVO NOVO NOVO, 2004 godiste', null, 1),
       (10, 4000, 'Samsung SSD', 'Samsung ssd memorija od 256gb', null, 1),
       (11, 2500, 'Tastatura', 'Najobicnija krs tastatura', null, 1),
       (12, 1500, 'Mokasine', 'Jednom nosene, razlog prodaje: pogresan broj', null, 1),
       (13, 13000, 'Kancelarijska stolica', 'Kanc. stolica za sve tipove biznis ljudi i sve tipove kicme', null, 1),
       (14, 19000, 'MIDI keyboard', 'Alesis V49', null, 1),
       (15, 1750, 'Masazer', 'Masazer na struju, oslobadja bola trenutno', null, 1),
       (16, 5000, 'Sennheiser slusalice', 'Sennheiser v140', null, 1),
       (17, 50000, 'Nike prsluk', 'Nike prsluk za turbo debile', null, 1),
       (18, 6000000, 'Stan', 'Dvosobni stan, 60 kvadrata, centar grada', null, 1),
       (19, 10000, 'Set stapova za pecanje', 'Najnoviji stapovi za pecanje POVOLJNO', null, 1),
       (20, 40000, 'Bako kajak', 'Kajak star 10 godina, u dobro stanju', null, 1),
       (21, 45000, 'Trokrilni sifonjer', 'Ostava za sva vasa sranja i vase prnje', null, 1),
       (22, 120, 'Sveska', 'Sveska da pisete vase gluposti', null, 1),
       (23, 20, 'Maramice', 'Najobicnije maramice da istresete vasu nosinu odvratnu', null, 1),
       (24, 7000, 'LG televizor', 'Lg televizor da bolje i lepse pratite rijaliti stoko', null, 1),
       (25, 500, 'Ram za sliku', 'Ram za sliku u formatu A3 sa staklom', null, 1),
       (26, 4500, 'Nike pro combat', 'Nike aktivni ves za sport, da ne budete debeli', null, 1),
       (27, 110, '10 jaja', '10 jaja a klase, 55g-65g', null, 1),
       (28, 2000, 'Elasticna traka', 'Elasticna traka za trening, drugaciji nacin opterecenja za vase male misice', null, 1),
       (29, 1600, 'Daljinski upravljac', 'Daljinski upravljac za vas televizor da mozete da pojacate rijaliti program', null, 1),
       (30, 4000, 'Ogrlica protiv buva', 'Ogrlica za vaseg kera odvratnog da ga ne napadaju buve kad se valja po blatu', null, 1);




INSERT INTO AKCIJA(ID, DO_KAD, OD_KAD, PROCENAT, TEKST, PRODAVAC_ID)
VALUES (1, '2021-02-25', '2021-01-01', 20, 'AKCIJA AKCIJA AKCIJA TOP TOP TOP', 1);






INSERT INTO ARTIKAL_AKCIJA(ARTIKAL_ID, AKCIJA_ID)
VALUES (1, 1);






