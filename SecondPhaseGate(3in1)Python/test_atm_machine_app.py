import unittest
from atm_machine_app import AtmMachineApp

class TestAtmMachineApp(unittest.TestCase):
    def setUp(self):
        self.account1 = AtmMachineApp("Nicholas", "Ichukwu", 1010)
        self.account2 = AtmMachineApp("Moses", "Idowu", 2020)

    def test_atm_machine_app_is_created(self):
        self.assertIsNotNone(self.account1)

    def test_create_account1(self):
        self.assertEqual("Nicholas", self.account1.first_name)
        self.assertEqual("Ichukwu", self.account1.last_name)
        self.assertEqual(1010, self.account1.pin)

    def test_create_account2(self):
        self.assertEqual("Moses", self.account2.first_name)
        self.assertEqual("Idowu", self.account2.last_name)
        self.assertEqual(2020, self.account2.pin)

    def test_close_account1(self):
        self.account1.close_account();
        self.assertTrue(self.account1._is_closed)

    def test_deposit_money(self):
        self.account1.deposit_money(1010, 300)
        self.assertEqual(300, self.account1.balance)

    def test_invalid_pin_when_depositing_money_raise_exception(self):
        with self.assertRaises(ValueError):
            self.account1.deposit_money(1023, 200)

    def test_deposit_amount_is_less_than_zero_raise_exception(self):
        with self.assertRaises(ValueError):
            self.account1.deposit_money(1010, -50)

    def test_withdraw_money(self):
        self.account1.deposit_money(1010, 300)
        self.account1.withdraw_money(1010, 200)
        self.assertEqual(100, self.account1.balance)

    def test_invalid_pin_when_withdrawing_raise_exception(self):
        self.account1.deposit_money(1010, 400)
        with self.assertRaises(ValueError):
            self.account1.withdraw_money(1257, 200)

    def test_check_account_balance(self):
        self.account1.deposit_money(1010, 5000)
        self.assertEqual(5000, self.account1.balance)

    def test_transfer_money_valid(self):
        self.account1.deposit_money(1010, 300)
        self.account1.transfer_money(self.account2, 200, 1010)
        self.assertEqual(100, self.account1.balance)
        self.assertEqual(200, self.account2.balance)

    def test_transfer_money_while_account_is_close_raise_exception(self):
        self.account1.close_account()
        with self.assertRaises(ValueError):
            self.account1.transfer_money(self.account2, 500, 1010)

    def test_invalid_pin_when_transfer_money_raise_exception(self):
        self.account1.deposit_money(1010, 900)
        with self.assertRaises(ValueError):
            self.account1.transfer_money(self.account2, 500, 1234)

    def test_transfer_Amount_is_more_than_balance_raise_exception(self):
        self.account1.deposit_money(1010, 700)
        with self.assertRaises(ValueError):
            self.account1.transfer_money(self.account2, 1000, 1010)

    def test_change_pin(self):
        self.account1.change_pin(1010, 2222)
        self.assertEqual(2222, self.account1.pin)

    def test_change_pin_when_oldpin_is_not_correct_raise_exception(self):
        with self.assertRaises(ValueError):
            self.account1.change_pin(1011, 2222)

if __name__ == '__main__':
    unittest.main()

