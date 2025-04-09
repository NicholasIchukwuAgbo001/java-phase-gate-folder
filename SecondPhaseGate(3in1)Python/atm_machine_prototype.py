from random import random

from atm_machine_app import atm_machine_app

def __init__(self):
        self.accounts = []

def create_account(self, first_name, last_name, pin):
        account_number =  str(random.randint(1000000, 9999999))
        account = atm_machine_app(first_name, last_name, pin)
        self.accounts.append(account)
        return account_number

def close_account(self, account_number, pin):
        for account in self.accounts:
            if account.account_number == account_number and account.pin == pin:
                self.accounts.remove(account)
                return

def deposit(self, account_number, pin, amount):
        for account in self.accounts:
            if account.account_number == account_number and account.pin == pin:
                account.deposit_money(pin, amount)
                return


