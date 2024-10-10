<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Meine Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@1.0.2/css/bulma.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Ubuntu|Lora">
    <link rel="stylesheet" href="Style/style.css">
    <link rel="stylesheet" href="Style/header.css">
    <!--<link rel="stylesheet" href="Style/homeScreenAnimations.css"> bereitet in der Form Design-Fehler (out-of-bildschirm)-->
</head>

<body class="gradient">
    <div>
        
        <?php include 'header.php'; ?>

        <i class="fa-solid fa-user"></i>

        <div class="container">
            <h2 class="text-light">Texte schneller lesen können... aber wie?!</h2>
            <br>
            <h2 class="text-light">Finde es heraus: gib einfach einen etwas längeren Text ein und lass ihn dir anzeigen</h2>
            <textarea class="textarea" id="input_text_readspeed" placeholder="Lorem ipsum..."></textarea>
            <button class="button" id="get_input_text_button">Anzeigen</button>
            <h3 class="text-light">Dein Text - den du (hoffentlich) schneller lesen kannst:</h3>

            <div class="bg-light" style="border-radius:10px;">
                <h2 class="text-dark" id="upspeadedText"></h2>
            </div>

            <button class="button" id="how_it_works_button">Wie funktioniert es?</button>

            <div class="bg-info p-2" id="how_it_works" style="border-radius: 10px;">
                <span class="bg-danger p-1 text-white">Wie es funktioniert</span>
                <br>
                <span class="text-white">
                    Ich kann mich nicht mehr genau an die Begründung erinnern. Aber sie ging ansatzweise folgendermaßen:
                    A: Das Gehirn kann die Wörter durch die dick geschriebenen Anfangsbuchstaben besser trennen / auseinanderhalten.
                    B: Dieses auseinanderhalten hilft demnach u.A. dabei, die dick geschriebenen Buchstaben direkt zu identifizieren
                    und die Bedeutung des Wortes, ohne es ganz lesen zu müssen, schnell zu verstehen 
                </span>
            </div>
        </div>
        
        <div class="container">
            Footer
        </div>

    </div>

    <script type="application/x-javascript" src="Script/ButtonListeners/universalButtons.js"></script>
    <script type="application/x-javascript" src="Script/ButtonListeners/readSpead.js"></script>
    <script type="application/x-javascript" src="Script/ReadSpead/readSpeed.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>