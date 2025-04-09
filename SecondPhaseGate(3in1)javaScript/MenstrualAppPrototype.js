const MenstrualApp = require('./MenstrualApp.js');
const menstrualApp = new MenstrualApp();
console.log("\nWelcome to your menstrual cycle tracker app");

const prompt = require('prompt-sync')();

while (true) {
    let choice = prompt("\nEnter your last menstrual period date (yyyy-MM-dd): ");
    try {
        menstrualApp.lastDate(choice);
        break;
    } catch (error) {
        console.error(error.message);
    }
}

while (true) {
    let cycleLength = prompt("\nEnter your cycle length in days: ");
    if (!isNaN(cycleLength) && cycleLength > 0) {
        menstrualApp.cycleLength(cycleLength);
        break;
    } else {
        console.error("\nInvalid cycle length. Please enter a positive number.");
    }
}

while (true) {
    let periodLength = prompt("\nEnter your period length in days: ");
    if (!isNaN(periodLength) && periodLength > 0 && periodLength <= menstrualApp.mainCycleLength) {
        menstrualApp.periodLength(periodLength);
        break;
    } else {
        console.error("Invalid period length. Please enter a positive number that is less than or equal to your cycle length.");
    }
}

console.log("Your next period date is: " + menstrualApp.nextPeriodDate());
console.log("Your ovulation date is: " + menstrualApp.ovulationDate());
console.log("Your fertile start date is: " + menstrualApp.fertileStartDate());
console.log("Your fertile end date is: " + menstrualApp.fertileEndDate());
console.log("Thank you for using the menstrual cycle tracker app. Have a great day!");