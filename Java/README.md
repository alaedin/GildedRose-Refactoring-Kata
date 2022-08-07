# Gilded Rose Refactoring Kata



In this implementation I Tried to create refactored code to simplify changes and maintains of this application.<br/>
I started by creating tests to guarantee the existing behavior, next I tried to separate the business logic
from many IF conditions to separated methods, each one handles a single functionality.</br>
Then I created classes to implement the factory pattern.
Finally, I added the Conjured Class to support the new category

# *HOW TO RUN*

The main method in [TexttestFixture](src/test/java/com/gildedrose/TexttestFixture.java) class, to test new items
1. add a new Item in the `items` array.(if needed)
2. Run the main method

## Adding new category to the system

1. Create new class implements [Item](src/main/java/com/gildedrose/entity/Item.java)
2. Override the `update()` method by the desired logic
3. Add the Category type in the [ConstantUtils](src/main/java/com/gildedrose/utils/ConstantUtils.java) class
4. Put the new category in the `SPECIALIZED_ITEM_TYPE` map  in the
   [ItemTypeDefiner](src/main/java/com/gildedrose/utils/ItemTypeDefiner.java) class
5. Add the new Items to the items array in the `main` method
6. Run the main

## Test the application
The existing test covers ***3315*** test scenarios.
1. Run the [GildedRoseTest](src/test/java/com/gildedrose/GildedRoseTest.java) class, the result of the tests' scenario
   exists in the [GildedRoseTest.updateQuality.approved](src/test/java/com/gildedrose/GildedRoseTest.updateQuality.approved.txt) file
####  Adding new category to the test :
1. Add new categoryName to the names array in the [GildedRoseTest](src/test/java/com/gildedrose/GildedRoseTest.java) class
2. If the value of the new category (sellIn or Quality) doesn't in the sellInRange or qualityRange, update them to cover the new changes
3. Run the updateQuality test
    1. An error will be raised
    2. New file `GildedRoseTest.updateQuality.received.txt` will be created, rename it to
       `GildedRoseTest.updateQuality.approved.txt`, this file contains the list of the new covered test scenarios
4. Run the test again it will support the new changes
