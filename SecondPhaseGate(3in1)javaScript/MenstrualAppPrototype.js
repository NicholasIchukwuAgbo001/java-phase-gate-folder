const MenstrualApp = require('./MenstrualApp.js');
const menstrualApp = new MenstrualApp();
console.log("\nWelcome to your menstrual cycle tracker app");

const prompt = require('prompt-sync')();

while (true) {
    let choice = prompt("Enter your last menstrual period date (yyyy/MM/dd): ");
    try {
        menstrualApp.lastDate(choice);
        break;
    } catch (error) {
        console.error(error.message);
    }
}


while (true) {
    let cycleLength = prompt("Enter your cycle length in days: ");
    if (!isNaN(cycleLength) && cycleLength >= 21 && cycleLength <= 35 && cycleLength % 1 === 0) {
        menstrualApp.cycleLength(cycleLength);
        break;
    } else {
        console.error("Invalid cycle length. Please enter a number between 21 and 35.");
    }
}


while (true) {
    let periodLength = prompt("Enter your period length in days: ");
    if(!isNaN(periodLength) && periodLength >= 1 && periodLength <= 7 && periodLength % 1 === 0) {
     menstrualApp.periodLength(periodLength);
     break
    }else{
        console.error("Invalid period length. Please enter a number between 1 and 7. ")
    }
}

console.log("Your ovulation date is: " + menstrualApp.ovulationDate());
console.log("Your fertile start date is: " + menstrualApp.fertileStartDate());
console.log("Your fertile end date is: " + menstrualApp.fertileEndDate());
console.log("Your next period date is: " + menstrualApp.predictNextPeriodDate());
console.log("Thank you for using the menstrual cycle tracker app. Have a great day!");