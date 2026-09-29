# Erklärung der JSON-Datei `tennis_booking_database.json`

## Wozu dient die Datei?

Die JSON-Datei ist der Bauplan für den Datenbankteil des Tennisreservierungsprojekts. Sie beschreibt, welche Arten von Daten die App speichern muss, wie diese Daten zusammenhängen und welche Regeln die App beim Buchen beachten soll. Sie enthält keine echten Nutzer- oder Buchungsdaten und führt selbst keine Funktionen aus. Das Entwicklerteam verwendet sie als gemeinsame Grundlage, um die Datenbank und die Buchungslogik im Programm umzusetzen.

## So ist die Datei aufgebaut

### Allgemeine Angaben

`database`, `schemaVersion`, `language`, `description` und `projectDescriptionDe` kennzeichnen das Projekt und fassen den Zweck der Datei auf Englisch beziehungsweise Deutsch zusammen. `money` legt fest, dass Preise in Euro mit zwei Nachkommastellen gespeichert werden.

### Erlaubte Werte

`enums` enthält festgelegte Auswahlwerte, damit im Programm einheitliche Bezeichnungen verwendet werden. Beispiele sind `member` und `external` für den Mitgliedsstatus, `indoor` und `outdoor` für den Standorttyp sowie `hard` und `grass` für den Belag. Auch die möglichen Buchungs- und Rabattcode-Status stehen hier.

### Preise und Buchungsregeln

`configuration` enthält veränderbare Projektregeln:

- `hourlyPricesEUR`: 20 Euro pro Stunde für Mitglieder und 35 Euro für externe Nutzer.
- `bookingRules`: Mindestdauer, Zeitschritt, Zeitzone und die Regel zur Prüfung von Überschneidungen.
- `loyalty`: legt fest, dass nach jeweils zehn abgeschlossenen Buchungen ein Rabattcode ausgegeben wird.

Rabattwert, Rabattart und Gültigkeitsdauer sind noch `null`, weil sie in der Aufgabenstellung nicht angegeben wurden. Das Team muss diese Werte festlegen, bevor die Rabattcodes in der App eingelöst werden können.

### Datenobjekte unter `entities`

`entities` beschreibt die vier zentralen Datensammlungen. In einer relationalen Datenbank werden daraus typischerweise Tabellen.

- `users`: Nutzer- und Platzwartkonten. `membershipType` bestimmt, welcher Stundenpreis gilt; `role` unterscheidet Kunden vom Platzwart. Es wird nur ein Passwort-Hash gespeichert.
- `courts`: Tennisplätze mit Name, Aktivstatus, Standorttyp und Belag. Indoor/Outdoor und Hartplatz/Grasplatz sind getrennte Merkmale.
- `bookings`: Verknüpft einen Nutzer mit einem Platz und einem Zeitraum. Zusätzlich werden Status, damaliger Stundenpreis und berechneter Gesamtpreis gespeichert. So ändern spätere Preisänderungen keine alten Buchungen.
- `discountCodes`: Speichert den persönlichen Code, zu welchem Buchungsmeilenstein er gehört, seinen Status und – falls eingelöst – die zugehörige Buchung.

Jedes Datenobjekt enthält `fields` mit den Feldnamen und ihren Eigenschaften, etwa Datentyp, Pflichtfeld, Standardwert oder Verweis auf ein anderes Objekt. `primaryKey` bezeichnet den eindeutigen Hauptschlüssel. `indexes` nennt Felder, nach denen die App häufig sucht. `constraints` listet zusätzliche Prüfungen, die beim Speichern gelten müssen.

### Verknüpfungen und Anwendungsregeln

`relationships` zeigt, wie Nutzer, Plätze, Buchungen und Rabattcodes miteinander verbunden sind. Zum Beispiel kann ein Nutzer mehrere Buchungen haben, aber jede Buchung gehört zu genau einem Nutzer und einem Platz.

`businessRules` beschreibt die Abläufe, die die Anwendung umsetzen soll: Doppelbuchungen verhindern, Mitglieds- oder externen Preis anwenden, erfolgreiche Buchungen zählen und nach jedem zehnten Abschluss einen Code ausgeben. Die Prüfung auf freie Plätze und das Speichern der Reservierung müssen zusammen abgesichert werden, damit parallele Buchungsversuche keine Doppelbuchung erzeugen.

### Verfügbarkeit und abgeleitete Werte

`availabilityQuery` beschreibt, welche Informationen eine Verfügbarkeitsabfrage erhält und zurückgibt. Eine Buchung überschneidet einen gesuchten Zeitraum, wenn ihr Beginn vor dem gewünschten Ende und ihr Ende nach dem gewünschten Beginn liegt. Die App zeigt den Platz dann als gebucht an.

`derivedValues` enthält Werte, die aus gespeicherten Daten berechnet werden, zum Beispiel die Anzahl abgeschlossener Buchungen eines Nutzers. Diese Anzahl wird aus den Buchungen ermittelt und nicht als unabhängig änderbarer Zähler gespeichert.

### Anfangsdaten und Hinweise

`initialData` enthält leere Listen für Nutzer, Plätze, Buchungen und Rabattcodes. Es sind also keine Beispieldaten oder echten persönlichen Daten enthalten.

`implementationNotes` nennt Entscheidungen oder Erweiterungen, die bei der Umsetzung zu beachten sind. Zum Beispiel sind Öffnungszeiten und Schließtage in der aktuellen Version noch nicht modelliert.

## Was das Team damit macht

Die Datei kann als Referenz beim Erstellen der Datenbanktabellen, Beziehungen und Eingabeprüfungen dienen. Anschließend implementiert das Team in der gewählten Programmiersprache die Funktionen, die diese Regeln verwenden: Plätze suchen, Zeiträume prüfen, Buchungen anlegen, Preise berechnen und Rabattcodes verwalten. Die JSON-Datei selbst ist weder die fertige Datenbank noch ein ausführbares Programm.
