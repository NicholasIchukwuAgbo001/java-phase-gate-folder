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

if __name__ == '__main__':
    unittest.main()

