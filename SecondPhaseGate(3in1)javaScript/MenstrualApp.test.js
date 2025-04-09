const MenstrualApp = require('./MenstrualApp.js'); 

const period = new MenstrualApp();

test("predict next period date", () => {
    period.lastDate('2023/10/01');
    period.cycleLength(28);
    period.periodLength(5);
    expect(period.predictNextPeriodDate()).toBe('10/29/2023');
});

test("calculate ovulation date", () => {
    period.lastDate('2023/10/01');
    period.cycleLength(28);
    period.periodLength(5);
    expect(period.ovulationDate()).toBe('10/15/2023');
});

test("calculate fertile start date", () => {
    period.lastDate('2023/10/01');
    period.cycleLength(28);
    period.periodLength(5);
    expect(period.fertileStartDate()).toBe('10/10/2023');
});
 
test("calculate fertile end date", () => {
    period.lastDate('2023/10/01');
    period.cycleLength(28);
    period.periodLength(5);
    expect(period.fertileEndDate()).toBe('10/15/2023');
});  

