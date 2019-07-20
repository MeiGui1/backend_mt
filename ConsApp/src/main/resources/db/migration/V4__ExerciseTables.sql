CREATE TABLE ExerciseType (
    title text PRIMARY KEY,
    explanation text
);

CREATE TABLE PatientExercise (
    patient_id int NOT NULL,
    exercisetype_title text NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES Patient(id),
    FOREIGN KEY (exercisetype_title) REFERENCES ExerciseType(title),
    UNIQUE (patient_id, exercisetype_title)
);


CREATE TABLE ExercisePhoto (
    id serial PRIMARY KEY,
    patient_id int NOT NULL,
    photo bytea NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES Patient(id)
);


INSERT INTO ExerciseType (title, explanation) VALUES ('Übung1','Erklärung');
INSERT INTO ExerciseType (title, explanation) VALUES ('Übung2','Erklärung');
INSERT INTO ExerciseType (title, explanation) VALUES ('Übung3','Erklärung');
INSERT INTO ExerciseType (title, explanation) VALUES ('Übung4','Erklärung');
INSERT INTO ExerciseType (title, explanation) VALUES ('Übung5','Erklärung');
INSERT INTO ExerciseType (title, explanation) VALUES ('Übung6','Erklärung');


INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('1', 'Übung1');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('1', 'Übung4');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('2', 'Übung2');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('3', 'Übung2');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('3', 'Übung5');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('4', 'Übung1');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('5', 'Übung1');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('6', 'Übung3');
INSERT INTO PatientExercise (patient_id, exercisetype_title) VALUES ('6', 'Übung2');

