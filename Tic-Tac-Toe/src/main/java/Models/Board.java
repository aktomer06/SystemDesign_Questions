package Models;

import Command.Symbol;

public class Board {
    //private List<List<BoardCell>> cells = new ArrayList<>();
    Models.BoardCell[][] cells;
    public Integer filledCells = 0;
    public Board(int rows, int cols) {
        cells = new Models.BoardCell[rows][cols];
        for(int i = 0; i< rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                cells[i][j] = new Models.BoardCell(i,j, Symbol.E);
            }
        }

//        List<BoardCell> columnCells = Collections.nCopies(cols, new BoardCell());
//        List<List<BoardCell>> rowCells = Collections.nCopies(rows, columnCells);
//        List<BoardCell> colCells = Arrays.asList(new BoardCell[cols]);
//        this.cells = Arrays.asList(colCells[rows]);
//        for(int i = 0; i < rows; i++) {
//            rowCells.add(new );
//        }
//        for(int j = 0; j < cols; j++) {
//            rowCells.at
//        }

//        this.cells = rowCells;
    }

    public Models.BoardCell[][] getCells() {
        return cells;
    }

    public void setCells(Models.BoardCell[][] cells) {
        this.cells = cells;
    }
    public void printBoard() {
        for(int i = 0; i < this.cells.length; i++)
        {
            for(int j = 0; j < this.cells[i].length; j++)
            {
                if(cells[i][j].symbol == Symbol.E)
                {
                    System.out.print("- | ");
                }
                else
                {
                    System.out.print(cells[i][j].getSymbol() + " | ");
                }
            }
            System.out.println("");
        }
    }
}
