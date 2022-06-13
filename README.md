# MobDevProject
Projet dev Mobile (sporting app)

The goal of this project is to deliver a sporting app that would enable coaches to save significant information about matches and debrief objectively using statistics with their players.

A good app to get inspired from is "tennis tracker" (look it up - https://play.google.com/store/apps/details?id=com.nabocorp.tennistracker.android.tennistracker&hl=fr).

Design constraints :

1- ergnomic interface (use fragments, menus like toolbars and navigation drawers, ...), adapt the interface to landscape, portrait, french and english
  a. On est parti sur un navigation drawer
  b. Ajout d'une interface par fonctionnalité pour une ergonomie optimal

2- locate the matches (latitude, longitude and geocoding - transform these into a street name)
  a. Visionner le cours de geolocalisation en vidéo
  b. Comprendre et adapter

3- take pictures of the match and save them locally

4- save statistics locally for 5 previous matches (in a sqlite database)

5- save full statistics on a real external database

6- be able to display information about any previous match (read the information from the local database or the distant one)

7- UP TO YOU TO DEFINE MORE FUNCTIONS
