from atm_machine_prototype import atm_machine_main

def main():
    bank = atm_machine_main
    while True:
        print("\n1. Create Account")
        print("2. Close Account")
        print("3. Deposit Money")
        print("4. Exit")
        choice = input("\nEnter your choice: ")
        if choice == '1':
            first_name = input("\nEnter your first name: ")
            last_name = input("\nEnter your last name: ")
            pin = int(input("\nEnter your PIN: "))
            account_number = bank.create_account(first_name, last_name, pin)
            print("\nAccount created successfully. Your account number is: ", account_number)
        elif choice == '2':
            account_number = input("\nEnter your account number: ")
            pin = int(input("\nEnter your PIN: "))
            bank.close_account(account_number, pin)
            print("\nAccount closed successfully.")
        elif choice == '3':
            account_number = input("\nEnter your account number: ")
            pin = int(input("\nEnter your PIN: "))
            amount = float(input("\nEnter the amount to deposit: "))
            bank.deposit(account_number, pin, amount)
            print("\nDeposit of ", amount, " was successful.")
        elif choice == '4':
            print("Thanks for banking with us (BANKE BANK) ...")
            break
        else:
            print("Invalid choice. Please choose a valid option.")

if __name__ == '__main__':
    main()