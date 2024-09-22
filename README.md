# Schach
Ein privates Projekt meinerseits - das Spiel, in das ich mich am meisten verliere, nachentwickeln (-> zu 100% in Java. Stockfish nimmt allerdings den größten Anteil mit C++ ein)

To-Do:
- [X] Diagonale-berechnen: Indizes für 'int[] position' werden von der For-Schleife übernommen
- [X] abstrakte Klasse für Figuren aktualisieren. Die hinzugefügten Methoden aus Bishop.java müssen noch eingebaut werden
- [X] CalculateKnightJumps abfragen per Schleife vereinfachen. Bisher sind es 8 aufrufe für alle Möglichkeiten
- [X] pgn mit objectPGN ersetzen -> erlöst die switch case mit 12 Abfragen
- [ ] PGN erstellen lassen (nachdem die Logik selbst zuende ist...)
- [ ] FEN für Stockfish erstellen lassen
- [ ] Stockfish (o.Ä. KI) einbauen
- [ ] bei doppelklick auf Figur die potentiellen Züge entfernen (nicht mehr markieren lassen)
- [ ] BUG: potentielle Schläge der Dame werden bei einer großen Auswahl - wie soll ich das beschreiben... sehr komisch (?)
