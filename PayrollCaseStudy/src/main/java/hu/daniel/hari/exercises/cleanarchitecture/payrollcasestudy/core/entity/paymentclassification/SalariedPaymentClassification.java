package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.core.entity.paymentclassification;

import hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.core.entity.DateInterval;

import java.time.temporal.TemporalAdjusters;

public abstract class SalariedPaymentClassification extends StrictIntervalPaymentClassification {

	public abstract int getMonthlySalary();
	public abstract void setMonthlySalary(int monthlySalary);

	@Override
	protected int calculateAmountOnValidatedInterval(DateInterval dateInterval) {
		return getMonthlySalary();
	}
	
	@Override
	protected boolean isValidInterval(DateInterval dateInterval) {
		return isFullMonthInterval(dateInterval);
	}

	private static boolean isFullMonthInterval(DateInterval dateInterval) {
		boolean fromIsFirstDayOfMonth = dateInterval.from.equals(dateInterval.from.with(TemporalAdjusters.firstDayOfMonth()));
		boolean toIsLastDayOfMonth = dateInterval.to.equals(dateInterval.to.with(TemporalAdjusters.lastDayOfMonth()));
		return fromIsFirstDayOfMonth && toIsLastDayOfMonth;
	}
	
}
