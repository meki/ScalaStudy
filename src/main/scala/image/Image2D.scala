package image

import scalax.file.Path
import scala.util.Random

// 2次元画像クラス
class Image2D(width: Int, height: Int) {

	// Int に Pixel という別名をつける
	type Pixel = Int

	// pixel data
	val mPixel = new Array[Pixel](width * height)

	// getter
	def get(x: Int, y: Int) = {
		mPixel(x + y * width)
	}

	// setter
	def set(x: Int, y: Int, value: Pixel): Unit = {
		mPixel(x + y * width) = value
	}

	// 画像にランダム値をセットする
	def setRandom(): Unit = {

		// scala.Util.Random インスタンス作成
		var r = new Random
		r.setSeed(1234)

		for(y <- 0 to height - 1) {
			for(x <- 0 to width - 1) {
				// ピクセルに [0-255] のランダム値をセット
				set(x, y, r.nextInt(256))
			}
		}
	}

  // pgm 形式で画像をファイル出力
  def saveAsPgm(name: String): Unit = {

	// pgm 画像ヘッダ情報
	var s = "P2\n"
	s += "%d %d\n".format(width, height)
	s += "255\n\n"

	// ピクセル情報
	for(y <- 0 to height - 1) {
		for(x <- 0 to width - 1) {
			s += " %d".format(get(x, y))
		}
		s += "\n"
	}

	var path = Path(name + ".pgm")
	// 既存ファイルを削除
	path.delete()
	// 新規ファイル作成
	path.createFile()
	// 画像情報をファイルに書き込む
	path.write(s)
  }
}
