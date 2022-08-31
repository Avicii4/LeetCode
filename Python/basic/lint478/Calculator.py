class Calculator:
    """
    @param a: An integer
    @param op: A character, +, -, *, /.
    @param b: An integer
    @return: The result
    """

    def calculate(self, a: int, op: str, b: int) -> int:
        # write your code here
        if op == '+':
            return a + b
        elif op == '-':
            return a - b
        elif op == '*':
            return a * b
        else:
            return a // b
