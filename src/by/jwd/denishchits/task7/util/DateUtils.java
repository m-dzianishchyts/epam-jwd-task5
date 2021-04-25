package by.jwd.denishchits.task7.util;

import by.jwd.denishchits.service.IllegalValueException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateUtils {

    private DateUtils() {
    }

    public static String defineDayOfWeek(Calendar calendar) throws IllegalValueException {
        if (calendar == null) {
            throw new IllegalValueException("Calendar cannot be null.");
        }
        SimpleDateFormat weekDayFormat = new SimpleDateFormat("EEEE");
        String dayOfWeekName = weekDayFormat.format(calendar.getTime());
        return dayOfWeekName;
    }

    public static int calculateDiffInYears(Calendar calendarA, Calendar calendarB) throws IllegalValueException {
        if (calendarA == null || calendarB == null) {
            throw new IllegalValueException("Calendar cannot be null.");
        }
        int diffInYears = calendarA.get(Calendar.YEAR) - calendarB.get(Calendar.YEAR);
        if (calendarB.get(Calendar.MONTH) > calendarA.get(Calendar.MONTH) ||
                (calendarB.get(Calendar.MONTH) == calendarA.get(Calendar.MONTH)
                && calendarB.get(Calendar.DATE) > calendarA.get(Calendar.DATE))) {
            diffInYears--;
        }
        return diffInYears;
    }

    public static boolean isTodayAnnually(Calendar calendar) throws IllegalValueException {
        if (calendar == null) {
            throw new IllegalValueException("Calendar cannot be null.");
        }
        Calendar today = Calendar.getInstance();
        boolean isToday = calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR);
        return isToday;
    }
}
