<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meine Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ubuntu|Lora">
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/header.css">
    <!--<link rel="stylesheet" href="Style/homeScreenAnimations.css"> bereitet in der Form Design-Fehler (out-of-bildschirm)-->
</head>

<body class="gradient">
    <div>
        
        <?php include 'html/header.php'; ?>

        <div class="container">
            <div class="bg-blue d-flex justify-content-center">
                <div class="text-center text-white" >
                    <p class="line-1 anim-typewriter yoSoyMatthes" style="font-weight: bold; font-size: 4.5em; margin: 0;"
                    >Hallo, ich bin Matthes👋</p>
                </div>
            </div>
            <div class="row text-center" style="display:flex;align-items: center; height:100%;">
                <div class="col-lg m-2 projectsContainer">
                    <div class="col">
                        <div class="rowOneCurrentProjects" id="currentProjects">
                            <h1>Aktuelle Projekte</h1>
                        </div>
                        <div class="container row projectOne m-2" id="projectChess">
                            <div class="col">
                                <img class="img-fluid" src="assets/chess.png">
                            </div>
        
                            <div class="col">
                                <span>
                                    <h5>Schach
                                        <i class="bi bi-x-circle-fill" style="height:1rem; color: rgb(195, 0, 0);"></i>
                                    </h5>
                                    <p>Ein Spiel, für das ich brenne. Seit langem auf meiner To-Do-Liste</p>
                                    <p>Siehe Github README für den aktuellen Stand</p>
                                </span>
                            </div>
                        </div>

                        <hr>

                        <div class="container row projectTwo m-2" id="projectDame">
                            <div class="col">
                                <img class="img-fluid" src="assets/dame.png">
                            </div>
        
                            <div class="col">
                                <span>
                                    <h5>Dame
                                        <i class="bi bi-check-circle-fill" style="height:1rem; color: rgb(0, 195, 0);"></i>
                                    </h5>
                                    <p>Unser Abschlussprojekt für das Modul 'AOP II'</p>
                                </span>
                            </div>
                        </div>
                    </div>   
                </div>
                <div class="col-md m-2 projectsContainer" id="knowledge">
                    <div class="col rowTwo">
                        <h1>Mein Bildungsweg</h1><h4>in a nutshell</h4>
                        Grundschule<br>Hauptschule<br>Realschulabschluss<br>Ausbildung<br>
                        SIKE<br>ich mach jetzt ein Praktikum<br>Okay arbeiten ist nicht meins, ich gehe auf die FOS<br>
                        FOS war cool. Ich gehe jetzt studieren<br>Informatikstudium
                    </div>
                </div>

                <div class="col-md m-2 projectsContainer" id="aboutme">
                    <div class="col rowThree">
                        <h1>Über mich</h1>
                        Ich könnte hier viel schreiben. Ich bin ein Entrepreneur. Ich bin Gott. Ich bin alles.
                        Aber nichts würde passen. Lieber leite ich dich auf den Feed weiter, auf dem ich versuche
                        mich selbst zu verstehen. Eine Art <strike>Jakobsweg</strike> Matthesweg
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            Footer
            <button><a href="readspeed.php">ReadSpeed testen</a></button>
        </div>

    </div>

    <script type="application/x-javascript" src="Script/ButtonListeners/universalButtons.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>