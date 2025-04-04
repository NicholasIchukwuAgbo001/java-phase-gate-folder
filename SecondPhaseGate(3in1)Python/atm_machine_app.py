class AtmMachineApp:
    def __init__(self, first_name, last_name, pin):
        self._first_name = first_name
        self._last_name = last_name
        self._pin = pin
        self._balance = 0
        self._is_closed = False

    @property
    def first_name(self):
        return self._first_name

    @property
    def last_name(self):
        return self._last_name

    @property
    def pin(self):
        return self._pin

    @property
    def balance(self):
        return self._balance