 CREATE TABLE ExerciseType (
    title text PRIMARY KEY,
    explanation text
);

CREATE TABLE PatientExercise (
    patient_id int NOT NULL,
    exercisetype_title text NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES Patient(id) ON DELETE CASCADE,
    FOREIGN KEY (exercisetype_title) REFERENCES ExerciseType(title) ON DELETE CASCADE,
    UNIQUE (patient_id, exercisetype_title)
);


CREATE TABLE ExercisePhoto (
    id serial PRIMARY KEY,
    patient_id int NOT NULL,
    photo bytea NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES Patient(id) ON DELETE CASCADE
);


INSERT INTO ExerciseType (title, explanation) VALUES ('Selbstbeobachtung','Beachten Sie: Bei entspannter Unterkieferhaltung sind die Zähne nicht in Kontakt. Zu Vermeiden ist insbesondere unbewusstes Zusammenbeissen der Zähne, Vorschieben des Unterkiefers und Wangen- oder Lippenbeissen. Zur Erinnerung können gelbe Klebepunkte im alltäglichen Umfeld verteilt werden (Uhr, Handy, Auto, COmputer, etc.), welche als Wahrnehmungshilfe dienen.');
INSERT INTO ExerciseType (title, explanation) VALUES ('Muskeldehnung','Passive Dehnübungen der Kaumuskulatur sind vergleichbar mit dem bekannten Streching im Sport. Der linke Daumen stabilisiert auf den Schneidezähnen den Oberkiefer. Zeige- und Mittelfinger der anderen Hand ziehen den Unterkiefer locker nach unten, bis ein Spannungsgefühl (kein Schmerz!) empfunden wird. Diese Position für 6-10 Sekunden halten mit 10 Wiederholungen (mehrmals am Tag durchführen).');
INSERT INTO ExerciseType (title, explanation) VALUES ('MassageSchlaefe','Durch Zähneklappern können die Kaumuskeln mit den Fingern gespürt werden. Dort wird unter sanftem Druck der Fingerspitzen oder Handballen mit kreisenden Bewegungen massiert. Eine Vorbehandlung mit Kälte oder Wärme kann die Massage erleichtern. Durchführung mehrmals täglich.');
INSERT INTO ExerciseType (title, explanation) VALUES ('MassageWange','Durch Zähneklappern können die Kaumuskeln mit den Fingern gespürt werden. Dort wird unter sanftem Druck der Fingerspitzen oder Handballen mit kreisenden Bewegungen massiert. Eine Vorbehandlung mit Kälte oder Wärme kann die Massage erleichtern. Durchführung mehrmals täglich.');
INSERT INTO ExerciseType (title, explanation) VALUES ('Medikamentenpflaster','Über Nacht sind selbsthaftende Pflaster mit entzündungshemmenden Wirkstoffen zur Schmerzbehandlung geeignet.');


INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('1', 'Selbstbeobachtung');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('1', 'MassageWange');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('2', 'Muskeldehnung');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('3', 'Muskeldehnung');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('3', 'Medikamentenpflaster');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('4', 'Selbstbeobachtung');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('5', 'Selbstbeobachtung');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('6', 'MassageSchlaefe');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('6', 'Muskeldehnung');

