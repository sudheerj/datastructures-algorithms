def square_is_white(coordinates: str) -> bool:
    col = ord(coordinates[0]) -ord('a') + 1
    row = int(coordinates[1])

    return (col + row) % 2 == 1

def main():
    tests = [
        "a1", "a2", "a3", "a8",
        "b1", "b2", "b7", "b8",
        "c1", "c7",
        "d4", "d5",
        "e4", "e5",
        "f6", "g7",
        "h1", "h2", "h3", "h8"
    ]

    for square in tests:
        color = "White" if square_is_white(square) else "Black"
        print(f"{square} -> {color}")


if __name__ == "__main__":
    main()