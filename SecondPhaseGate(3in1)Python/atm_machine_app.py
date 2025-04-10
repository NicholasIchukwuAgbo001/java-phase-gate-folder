
class atm_machine_app:
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

    @property
    def is_closed(self):
        return self._is_closed

    def close_account(self):
        self._is_closed = True

    def deposit_money(self, pin, amount):
        if amount <= 0:
            raise ValueError("Amount must be greater than 0.")
        if self._pin == pin and not self._is_closed:
            self._balance += amount
        elif self._pin != pin:
            raise ValueError("Invalid PIN")
        else:
            raise ValueError("Account closed")

    def withdraw_money(self, pin, amount):
        if self._pin == pin and not self._is_closed:
            self._balance -= amount
        elif self._pin != pin:
            raise ValueError("Invalid PIN")

    def transfer_money(self, account2, amount, pin):
        if self._pin == pin and not self._is_closed and self._balance >= amount:
            self.withdraw_money(pin, amount)
            account2.deposit_money(account2.pin, amount)
        elif self._pin != pin:
            raise ValueError("Invalid PIN")
        elif self._is_closed:
            raise ValueError("Account closed")
        elif self._balance < amount:
            raise ValueError("Insufficient balance")

    def change_pin(self, oldPin, newPin):
        if self._pin == oldPin and not self._is_closed:
            self._pin = newPin
        else:
            raise ValueError("Invalid PIN")





