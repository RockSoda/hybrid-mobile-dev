package com.example.sigh.firstapp

import android.widget.ImageButton

class Piece(var id1: Int, var id2: Int, var btn1: ImageButton, var btn2: ImageButton, var player: Int, var board: Array<String>, var ldRookNeverMoved: Boolean, var rdRookNeverMoved: Boolean, var llRookNeverMoved: Boolean, var rlRookNeverMoved: Boolean, var dKingNeverMoved: Boolean, var lKingNeverMoved: Boolean, var previousPlayer: Int) {
    var checkValidity = false
    var id11 = -1
    var id12 = -1
    var id21 = -1
    var id22 = -1

    fun isValidMovement(): Boolean {
        return checkValidity
    }

    private fun setIDs() {
        if (id1 % 8 != 0) {
            id11 = 7 - id1 / 8
            if ((id1 / 8) % 2 == 0) {
                id12 = id1 % 8 - 1
            } else if ((id1 / 8) % 2 == 1) {
                id12 = 8 - id1 % 8
            }
        } else {
            id11 = 7 - (id1 / 8 - 1)
            if ((id1 / 8) % 2 == 0) {
                id12 = 0
            } else if ((id1 / 8) % 2 == 1) {
                id12 = 7
            }
        }

        if (id2 % 8 != 0) {
            id21 = 7 - id2 / 8
            if ((id2 / 8) % 2 == 0) {
                id22 = id2 % 8 - 1
            } else if ((id2 / 8) % 2 == 1) {
                id22 = 8 - id2 % 8
            }
        } else {
            id21 = 7 - (id2 / 8 - 1)
            if ((id2 / 8) % 2 == 0) {
                id22 = 0
            } else if ((id2 / 8) % 2 == 1) {
                id22 = 7
            }
        }
    }

    fun setOnBoard(): Array<Array<String>> {
        var changeRows: Boolean = true
        var counter: Int = 64
        var theBoard = Array(8, { arrayOf(" ", " ", " ", " ", " ", " ", " ", " ") })

        for (i in 0..theBoard.size - 1) {
            var rowArray = arrayOf(" ", " ", " ", " ", " ", " ", " ", " ")
            if (changeRows) {
                for (j in 0..7) {
                    rowArray[j] = board[counter]
                    counter--
                    changeRows = false
                }
            } else {
                for (j in 0..7) {
                    rowArray[7 - j] = board[counter]
                    counter--
                    changeRows = true
                }
            }

            theBoard[i] = rowArray
        }

        return theBoard
    }

    fun setPiece() {
        setIDs()
        var theBoard = setOnBoard()
        if (board[id1][0] != board[id2][0] && previousPlayer != player) {
            if (player == 0) {
                val rook = Rook(0, theBoard)
                val knight = Knight(0)
                val bishop = Bishop(0, theBoard)
                val queen = Queen(0, theBoard)
                val king = King(0)
                val pawn = Pawn(0, theBoard)
                checkValidity = rook.move() || knight.move() || bishop.move() || queen.move() || king.move() || pawn.move()

            } else if (player == 1) {
                val rook = Rook(1, theBoard)
                val knight = Knight(1)
                val bishop = Bishop(1, theBoard)
                val queen = Queen(1, theBoard)
                val king = King(1)
                val pawn = Pawn(1, theBoard)
                checkValidity = rook.move() || knight.move() || bishop.move() || queen.move() || king.move() || pawn.move()
            }
        }
    }

    inner class Rook(var player: Int, var theBoard: kotlin.Array<Array<String>>) {
        fun checkStraight(): Boolean {
            var tmp = -1
            if (id11 == id21) {
                if (id12 < id22) {
                    tmp = id22 - 1
                    while (tmp != id12) {
                        if (!theBoard[id11][tmp].equals(" ")) {
                            return false
                        }
                        tmp -= 1
                    }
                } else {
                    tmp = id22 + 1
                    while (tmp != id12) {
                        if (!theBoard[id11][tmp].equals(" ")) {
                            return false
                        }
                        tmp += 1
                    }
                }
            } else if (id12 == id22) {
                if (id11 < id21) {
                    tmp = id21 - 1
                    while (tmp != id11) {
                        if (!theBoard[tmp][id12].equals(" ")) {
                            return false
                        }
                        tmp -= 1
                    }
                } else {
                    tmp = id21 + 1
                    while (tmp != id11) {
                        if (!theBoard[tmp][id12].equals(" ")) {
                            return false
                        }
                        tmp += 1
                    }
                }
            }
            return true
        }

        fun rule(): Boolean {
            if (id11 == id21 || id12 == id22) {
                return checkStraight()
            }
            return false
        }

        fun move(): Boolean {
            if (player == 0) {
                if (board[id1] == "lRook" && rule()) {
                    btn1.setImageDrawable(null)
                    btn2.setImageResource(R.drawable.rlt6)
                    return true

                } else return false
            } else {
                if (board[id1] == "dRook" && rule()) {
                    btn1.setImageDrawable(null)
                    btn2.setImageResource(R.drawable.rdt6)
                    return true

                } else return false
            }

        }
    }

    inner class Pawn(var player: Int, var theBoard: kotlin.Array<Array<String>>) {

        fun rule(): Int {
            if (player == 0) {
                if ((id11 == 6) && ((id21 == 5 || id21 == 4) && id22 == id12 && theBoard[id21][id22].equals(" "))) {
                    return 1

                } else if ((id11 - 1 == id21 && id12 - 1 == id22) || (id11 - 1 == id21 && id12 + 1 == id22)) {
                    if (theBoard[id21][id22][0] == 'd') {
                        if (id21 == 0) {
                            return 2
                        } else {
                            return 1
                        }
                    }
                } else if ((id21 == id11 - 1) && (id12 == id22) && theBoard[id21][id22].equals(" ")) {
                    if (id21 == 0) {
                        return 2
                    } else {
                        return 1
                    }
                }
                return 0
            } else {
                if ((id11 == 1) && ((id21 == 2 || id21 == 3) && id22 == id12 && theBoard[id21][id22].equals(" "))) {
                    return 1
                } else if ((id11 + 1 == id21 && id12 - 1 == id22) || (id11 + 1 == id21 && id12 + 1 == id22)) {
                    if (theBoard[id21][id22][0] == 'l') {
                        if (id21 == 7) {
                            return 2
                        } else {
                            return 1
                        }
                    }
                } else if ((id21 == id11 + 1) && (id12 == id22) && theBoard[id21][id22].equals(" ")) {
                    if (id21 == 7) {
                        return 2
                    } else {
                        return 1
                    }
                }
                return 0
            }
        }

        fun move(): Boolean {
            if (player == 0) {
                if (board[id1] == "lPawn") {
                    var result = rule()
                    if (result == 1) {
                        btn1.setImageDrawable(null)
                        btn2.setImageResource(R.drawable.plt6)
                        return true
                    } else if (result == 2) {
                        btn1.setImageDrawable(null)
                        btn2.setImageResource(R.drawable.qlt6)
                        board[id1] = "lQueen"
                        return true
                    } else return false
                } else return false
            } else {
                if (board[id1] == "dPawn") {
                    var result = rule()
                    if (result == 1) {
                        btn1.setImageDrawable(null)
                        btn2.setImageResource(R.drawable.pdt6)
                        return true
                    } else if (result == 2) {
                        btn1.setImageDrawable(null)
                        btn2.setImageResource(R.drawable.qdt6)
                        board[id1] = "dQueen"
                        return true
                    } else return false
                } else return false
            }

        }

    }

    inner class King(var player: Int) {

        fun rule(): Boolean {
            if ((id21 == id11 || id21 == id11 - 1 || id21 == id11 + 1) && (id22 == id12 || id22 == id12 - 1 || id22 == id12 + 1)) {
                return true
            }
            return false
        }

        fun move(): Boolean {
            if (player == 0) {
                if (board[id1] == "lKing") {
                    if (rule()) {
                        btn1.setImageDrawable(null)
                        btn2.setImageResource(R.drawable.klt6)
                        return true
                    } else if (lKingNeverMoved) {
                        if (id2 == 7 && rlRookNeverMoved && board[6] == " " && board[7] == " ") {
                            btn1.setImageDrawable(null)
                            btn2.setImageResource(R.drawable.klt6)
                            return true
                        } else if (id2 == 3 && llRookNeverMoved && board[2] == " " && board[3] == " " && board[4] == " ") {
                            btn1.setImageDrawable(null)
                            btn2.setImageResource(R.drawable.klt6)
                            return true
                        } else return false
                    } else return false
                } else return false
            } else {
                if (board[id1] == "dKing") {
                    if (rule()) {
                        btn1.setImageDrawable(null)
                        btn2.setImageResource(R.drawable.kdt6)
                        return true
                    } else if (dKingNeverMoved) {
                        if (id2 == 58 && rdRookNeverMoved && board[59] == " " && board[58] == " ") {
                            btn1.setImageDrawable(null)
                            btn2.setImageResource(R.drawable.kdt6)
                            return true
                        } else if (id2 == 62 && ldRookNeverMoved && board[61] == " " && board[62] == " " && board[63] == " ") {
                            btn1.setImageDrawable(null)
                            btn2.setImageResource(R.drawable.kdt6)
                            return true
                        } else return false
                    } else return false
                } else return false
            }

        }
    }

    inner class Queen(var player: Int, var theBoard: kotlin.Array<Array<String>>) {
        var bishop = Bishop(player, theBoard)
        var rook = Rook(player, theBoard)

        fun rule(): Boolean = bishop.rule() or rook.rule()

        fun move(): Boolean {
            if (player == 0) {
                if (board[id1] == "lQueen" && rule()) {
                    btn1.setImageDrawable(null)
                    btn2.setImageResource(R.drawable.qlt6)
                    return true
                } else return false
            } else {
                if (board[id1] == "dQueen" && rule()) {
                    btn1.setImageDrawable(null)
                    btn2.setImageResource(R.drawable.qdt6)
                    return true
                } else return false
            }


        }
    }

    inner class Knight(var player: Int) {

        fun rule(): Boolean {
            if (id11 - 2 == id21) {
                if (id12 - 1 == id22 || id12 + 1 == id22) {
                    return true
                }
            } else if (id11 + 2 == id21) {
                if (id12 - 1 == id22 || id12 + 1 == id22) {
                    return true
                }
            } else if (id12 - 2 == id22) {
                if (id11 - 1 == id21 || id11 + 1 == id21) {
                    return true
                }
            } else if (id12 + 2 == id22) {
                if (id11 - 1 == id21 || id11 + 1 == id21) {
                    return true
                }
            }
            return false
        }

        fun move(): Boolean {

            if (player == 0) {
                if (board[id1] == "lKnight" && rule()) {
                    btn1.setImageDrawable(null)
                    btn2.setImageResource(R.drawable.nlt6)
                    return true
                } else return false
            } else {
                if (board[id1] == "dKnight" && rule()) {
                    btn1.setImageDrawable(null)
                    btn2.setImageResource(R.drawable.ndt6)
                    return true

                } else return false
            }

        }


    }

    inner class Bishop(var player: Int, var theBoard: kotlin.Array<Array<String>>) {

        fun checkSlant(): Boolean {
            var tmp1 = -1
            var tmp2 = -1
            if (id21 > id11) {
                if (id22 < id12) {
                    tmp1 = id21 - 1
                    tmp2 = id22 + 1
                    while (tmp1 != id11 && tmp2 != id12) {
                        if (!theBoard[tmp1][tmp2].equals(" ")) {
                            return false
                        }
                        tmp1 -= 1
                        tmp2 += 1
                    }
                } else if (id22 > id12) {
                    tmp1 = id21 - 1
                    tmp2 = id22 - 1
                    while (tmp1 != id11 && tmp2 != id12) {
                        if (!theBoard[tmp1][tmp2].equals(" ")) {
                            return false
                        }
                        tmp1 -= 1
                        tmp2 -= 1
                    }
                }
            } else if (id21 < id11) {
                if (id22 < id12) {
                    tmp1 = id21 + 1
                    tmp2 = id22 + 1
                    while (tmp1 != id11 && tmp2 != id12) {
                        if (!theBoard[tmp1][tmp2].equals(" ")) {
                            return false
                        }
                        tmp1 += 1
                        tmp2 += 1
                    }
                } else if (id22 > id12) {
                    tmp1 = id21 + 1
                    tmp2 = id22 - 1
                    while (tmp1 != id11 && tmp2 != id12) {
                        if (!theBoard[tmp1][tmp2].equals(" ")) {
                            return false
                        }
                        tmp1 += 1
                        tmp2 -= 1
                    }
                }
            }
            return true
        }

        fun rule(): Boolean {
            if (id11 + id12 == id21 + id22 || id11 - id12 == id21 - id22) {
                return checkSlant()
            }

            return false
        }

        fun move(): Boolean {
            if (player == 0) {
                if (board[id1] == "lBishop" && rule()) {
                    btn1.setImageDrawable(null)
                    btn2.setImageResource(R.drawable.blt6)
                    return true

                } else return false
            } else {
                if (board[id1] == "dBishop" && rule()) {
                    btn1.setImageDrawable(null)
                    btn2.setImageResource(R.drawable.bdt6)
                    return true
                } else return false
            }

        }
    }

}