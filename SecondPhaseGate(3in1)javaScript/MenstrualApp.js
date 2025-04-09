class MenstrualApp {
    constructor() {
        this.date = null;
        this.mainCycleLength = null;
        this.mainPeriodLength = null;
    }

    lastDate(date) {
        const dateRegex = /^\d{4}[\/-]\d{2}[\/-]\d{2}$/;
        if (!dateRegex.test(date)) {
            throw new Error("Invalid date format. Please use yyyy/MM/dd");
        }
        this.date = new Date(date.replace(/-/g, '/'));
    }
    
    

     cycleLength(length) {
        this.mainCycleLength = length;
    }

    periodLength(length) {
        this.mainPeriodLength = length;
    }

    predictNextPeriodDate() {
        if (this.date && this.mainCycleLength) {
            const nextPeriodDate = new Date(this.date);
            nextPeriodDate.setDate(nextPeriodDate.getDate() + this.mainCycleLength);
            return nextPeriodDate.toLocaleDateString();
        } else {
            return "Please set the last date and cycle length first.";
        }
    }
        
    ovulationDate() {
        if (this.date && this.mainCycleLength) {
            const ovulationDate = new Date(this.date);
            ovulationDate.setDate(ovulationDate.getDate() + (this.mainCycleLength - 14));
            return ovulationDate.toLocaleDateString();
        } else {
            return "Please set the last date and cycle length first.";
        }
    }

    fertileStartDate() {
        if (this.date && this.mainCycleLength) {
            const fertileDate = new Date(this.date);
            fertileDate.setDate(fertileDate.getDate() + (this.mainCycleLength - 14 - 5));
            return fertileDate.toLocaleDateString();
        } else {
            return "Please set the last date and cycle length first.";
        }
    }

    fertileEndDate() {
        if (this.date && this.mainCycleLength) {
            const fertileDate = new Date(this.date);
            fertileDate.setDate(fertileDate.getDate() + (this.mainCycleLength - 14));
            return fertileDate.toLocaleDateString();
        } else {
            return "Please set the last date and cycle length first.";
        }
    }


}

module.exports = MenstrualApp;
