package by.jwd.denishchits.task7.util;

import by.jwd.denishchits.service.InvalidArgumentException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateUtils {

    public static final String NULL_CALENDAR_MESSAGE = "Calendar cannot be null.";

    private DateUtils() {
    }

    public static String defineDayOfWeek(Calendar calendar) throws InvalidArgumentException {
        checkOnNull(calendar);
        SimpleDateFormat weekDayFormat = new SimpleDateFormat("EEEE");
        String dayOfWeekName = weekDayFormat.format(calendar.getTime());
        return dayOfWeekName;
    }

    public static int calculateDiffInYears(Calendar calendarA, Calendar calendarB) throws InvalidArgumentException {
        checkOnNull(calendarA, calendarB);
        int diffInYears = calendarA.get(Calendar.YEAR) - calendarB.get(Calendar.YEAR);
        if (calendarB.get(Calendar.MONTH) > calendarA.get(Calendar.MONTH) ||
                (calendarB.get(Calendar.MONTH) == calendarA.get(Calendar.MONTH)
                 && calendarB.get(Calendar.DATE) > calendarA.get(Calendar.DATE))) {
            diffInYears--;
        }
        return diffInYears;
    }

    public static boolean isTodayAnnually(Calendar calendar) throws InvalidArgumentException {
        checkOnNull(calendar);
        Calendar today = Calendar.getInstance();
        boolean isToday = calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR);
        return isToday;
    }

    private static void checkOnNull(Calendar calendarA, Calendar calendarB) throws InvalidArgumentException {
        if (calendarA == null || calendarB == null) {
            throw new InvalidArgumentException(NULL_CALENDAR_MESSAGE);
        }
    }

    private static void checkOnNull(Calendar calendar) throws InvalidArgumentException {
        if (calendar == null) {
            throw new InvalidArgumentException(NULL_CALENDAR_MESSAGE);
        }
    }
}
