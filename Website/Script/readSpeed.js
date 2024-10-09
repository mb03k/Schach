const outputDiv = document.getElementById("id__");

//button.addEventListener("click", function() {
    // Dynamischer HTML-Inhalt, der beim Klick auf den Button eingefügt wird
    //const dynamicContent = "<div style='color: blue; font-weight: bold;'>Das ist ein dynamischer Text!</div>";


    // Den HTML-Inhalt in das Div einfügen
    //outputDiv.innerHTML = dynamicContent;
//});

document.getElementById("get_input_text_button").onclick = function() {
    let inTxt;
    let splittetTxt = [];
    let finalTxt;

    inTxt = getInputText();
    splittetTxt = splitInputText(inTxt);
    finalTxt = setBoldings(splittetTxt); 
    writeToBody(finalTxt);
}

function getInputText() {
    return document.getElementById('input_text_readspeed').value;
}

function splitInputText(inTxt) {
    return inTxt.split(/\s+/);
}

function setBoldings(splittetTxt) {
    let newSplittetTxt = [];
    let returnString;
    let range;

    for (let h of splittetTxt) {
        range = calculateRange(h);

        let firstHalf = [];
        let secondHalf = [];

        for (let i=0; i<range; i++) {
            firstHalf.push(h[i]);
        }

        for (let i=range; i<h.length; i++) {
            secondHalf.push(h[i])
        }

        let first = firstHalf.join("");
        let second = secondHalf.join("");

        newSplittetTxt.push("<b>"+first+"</b>"+second+" ");
    }

    returnString = newSplittetTxt.join(" ");
    return returnString;
}

function calculateRange(currentString) {
    let length = currentString.length;
    // returns where the <b> should be placed
    if (length != null) {
        length *= 0.67;
        length = parseInt(length, 10);
        return length;
    }
    return null;
}

function writeToBody(finalTxt) {
    
    outputDiv.innerHTML = finalTxt;
}