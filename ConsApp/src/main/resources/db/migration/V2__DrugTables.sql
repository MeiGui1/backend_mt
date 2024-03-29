CREATE TABLE DrugType (
    id serial PRIMARY KEY,
    name text NOT NULL,
    description text
);

CREATE TABLE PatientDrug (
    patient_id int NOT NULL,
    drugtype_id int NOT NULL,
    amount text,
    dosis char(4),
    FOREIGN KEY (patient_id) REFERENCES Patient(id) ON DELETE CASCADE,
    FOREIGN KEY (drugtype_id) REFERENCES DrugType(id) ON DELETE CASCADE,
    UNIQUE (patient_id, drugtype_id)
);


INSERT INTO DrugType (name, description) VALUES ('Naproxen', 'Naproxen ist ein nicht-steroidaler Entzündungshemmer aus der Gruppe der Arylpropionsäuren mit schmerzlindernden, fiebersenkenden und entzündungshemmenden Eigenschaften. Der Wirkstoff wird zur Behandlung von Schmerzen, Fieber und Entzündungszuständen verschiedener Ursache verwendet und hat eine vergleichsweise lange Wirkdauer von etwa 8-12 Stunden.');
INSERT INTO DrugType (name, description) VALUES ('Amitriptylin','Amitriptylin ist ein stimmungsaufhellender Wirkstoff aus der Gruppe der trizyklischen Antidepressiva mit beruhigenden und angstlösenden Eigenschaften. Es wird einerseits zur Behandlung von depressiven Erkrankungen und andererseits auch gegen chronische Schmerzen eingesetzt. Die Effekte beruhen auf der Hemmung der Wiederaufnahme von Serotonin und Noradrenalin in das präsynaptische Neuron.');
INSERT INTO DrugType (name, description) VALUES ('Pregabalin','Pregabalin ist ein Wirkstoff aus der Gruppe der Antiepileptika, der zur Behandlung von Nervenschmerzen, einer Epilepsie und generalisierten Angststörungen eingesetzt wird. Die Effekte beruhen auf der Senkung der neuronalen Erregbarkeit.');
INSERT INTO DrugType (name, description) VALUES ('Duloxetin','Duloxetin ist ein stimmungsaufhellender und schmerzlindernder Wirkstoff aus der Gruppe der SSNRI zur Behandlung von Depressionen, Schmerzen, Angststörungen und Belastungsinkontinenz. Die Effekte beruhen auf der selektiven Hemmung der Wiederaufnahme von Serotonin und Noradrenalin.');
INSERT INTO DrugType (name, description) VALUES ('Mirtazapin','Mirtazapin ist ein stimmungsaufhellender und dämpfender Wirkstoff aus der Gruppe der tetrazyklischen Antidepressiva zur Akutbehandlung und zur Erhaltungstherapie bei einer unipolaren depressiven Episode. Die Effekte beruhen auf der verstärkten noradrenergen und serotonergen Aktivität im zentralen Nervensystem.');
INSERT INTO DrugType (name, description) VALUES ('Lamotrigin','Lamotrigin ist ein antikonvulsiver Wirkstoff aus der Gruppe der Antiepileptika, der zur Behandlung der Epilepsie und zur Vorbeugung depressiver Episoden bei Patienten mit einer bipolaren Störung eingesetzt wird.');
INSERT INTO DrugType (name, description) VALUES ('Topiramat','Topiramat ist ein Wirkstoff aus der Gruppe der Antiepileptika mit antikonvulsiven, neuroprotektiven, appetithemmenden und teratogenen Eigenschaften. Es wird zur Behandlung verschiedener Epilepsieformen und zur Migräneprophylaxe eingesetzt. Durch die Blockade von spannungsabhängigen Natrium- und Calciumkanälen wird die Erzeugung und die Anzahl von Aktionspotentialen und somit die Frequenz von Krampfanfällen vermindert.');
INSERT INTO DrugType (name, description) VALUES ('Magnesium','Magnesium ist ein essentieller Mineralstoff mit muskelentspannenden, abführenden und antiarrhythmischen Eigenschaften, der als Cofaktor zahlreicher Enzyme wirksam ist. Magnesium wird unter anderem bei Mangelzuständen, bei einem erhöhten Bedarf und bei Wadenkrämpfen eingenommen. Daneben existieren zahlreiche weitere Anwendungsgebiete. ');




INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES ('1', '1', '500mg', '1010');
INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES ('1', '3', '25mg', '0101');
INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES ('1', '6', '12.5mg', '0010');
INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES ('2', '1', '200mg', '1010');
INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES ('2', '6', '25mg', '1010');
INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES ('3', '5', '15mg', '1000');
INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES ('4', '8', '200mg', '0010');
INSERT INTO PatientDrug (patient_id, drugtype_id, amount, dosis) VALUES ('4', '7', '25mg', '0010');