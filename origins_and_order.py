def answer(x, y, z):
    list = [x, y, z]
    list.sort()
    month_to_last_day = {
        1: 31,
        2: 28,
        3: 31,
        4: 30,
        5: 31,
        6: 30,
        7: 31,
        8: 31,
        9: 30,
        10: 31,
        11: 30,
        12: 31
    }
    # Since we are sure to have one valid date, we can assume that
    # the smallest number will be the month as it has to be 1-12
    # the second smallest number will be the day 1-31
    # and the third number will be the year 1-99
    month = list[0]
    day = list[1]
    year = list[2]

    # Month and day are different numbers, but they are both less than 12,
    # the date is ambiguous
    if month != day and \
            (month <= 12 and day <= 12):
        return "Ambiguous"
    elif year != day and\
            (year <= month_to_last_day[month]):
        return "Ambiguous"
    else:
        return "{0:02}/{1:02}/{2:02}".format(month, day, year)

# Determinable
print(answer(19, 19, 3))
# Ambiguous
print(answer(2, 30, 3))
# Ambiguous
print(answer(9, 99, 2))
# Determinable
print(answer(99, 1, 13))
# Determinable
print(answer(2, 16, 16))
# Ambiguous
print(answer(8, 9, 15))
# Ambiguous
print(answer(10, 30, 15))
print(answer(2, 15, 16))
print(answer(12, 12, 12))
print(answer(12, 31, 32))
print(answer(1, 1, 5))
print(answer(2, 30, 14))
