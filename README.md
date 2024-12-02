# Simple Calculator App

A minimal Android app to perform basic arithmetic operations with an intuitive user interface.

## Features

- Addition
- Subtraction
- Multiplication
- Division (with error handling for division by zero)
- Power (Exponentiation)
- Modulus

## Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/IRedDragonICY/cb24153-lab-simplecalculator.git
   ```

2. Open the project in **Android Studio**.

3. Sync the Gradle files and build the project.

4. Run the app on an emulator or physical device.

## Code Overview

### `MainActivity.java`

- **Architecture**: Centralized handling of button clicks using a `HashMap` for button-operation mapping.
- **Key Logic**:
  - Operations are defined using Java's `BiFunction` interface.
  - Error handling for invalid inputs and division by zero.
- **UI Interaction**:
  - Retrieves input values from `EditText` fields.
  - Displays results in a read-only `EditText` field.


### `activity_main.xml`

- **Design**:
  - Simple layout with two input fields, one result field, and buttons for operations.
  - Organized using `LinearLayout` for buttons and a `RelativeLayout` for overall structure.
- **Customization**:
  - Stylish buttons with background tints.
  - Clear, readable typography for input and output fields.


## Usage

1. Enter two numbers in the input fields.
2. Select an operation button.
3. The result will appear in the result field.

## License

This project is licensed under the [MIT License](LICENSE).

## Author

- **IRedDragonICY**

