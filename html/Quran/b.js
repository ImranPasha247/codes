const startButton = document.getElementById('start-recitation');
const verseDisplay = document.getElementById('verseDisplay');

// Fetch Quran JSON data (you can serve it from a backend or load it locally)
let quranData;
fetch('quran.json')
    .then(response => response.json())
    .then(data => quranData = data);

startButton.addEventListener('click', () => {
    if ('webkitSpeechRecognition' in window || 'SpeechRecognition' in window) {
        const SpeechRecognition = window.SpeechRecognition || window.webkitSpeechRecognition;
        const recognition = new SpeechRecognition();
        
        recognition.lang = 'ar-SA'; // Set language to Arabic
        recognition.interimResults = false;
        recognition.maxAlternatives = 1;
        
        recognition.start();
        
        recognition.onresult = (event) => {
            const userRecitation = event.results[0][0].transcript;
            verseDisplay.textContent = userRecitation;
            
            // Compare with all Quranic verses
            let matchedVerse = findMatchingVerse(userRecitation);
            
            if (matchedVerse) {
                verseDisplay.textContent = `Matched: ${matchedVerse}`;
            } else {
                verseDisplay.textContent = "No match found.";
            }
        };

        recognition.onerror = (event) => {
            verseDisplay.textContent = "Error: " + event.error;
        };
    } else {
        verseDisplay.textContent = "Speech Recognition not supported in this browser.";
    }
});

function findMatchingVerse(userRecitation) {
    // Loop through all Quranic chapters and verses for a match
    for (let chapter in quranData) {
        for (let verse in quranData[chapter]) {
            let verseText = quranData[chapter][verse].toLowerCase();
            if (userRecitation.trim().toLowerCase().includes(verseText)) {
                return `Surah ${chapter}, Ayah ${verse}: ${verseText}`;
            }
        }
    }
    return null;
}
