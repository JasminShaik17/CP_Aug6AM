package cubex.mahesh.cp_aug6am

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.SimpleCursorAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resolver = contentResolver
    /* Uri uri, String[] projection, String selection,
    String[] selectionArgs, String sortOrder */
       var cursor =  resolver.query(
           ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                null,null,null,
                null)
        /* Context context, int layout, Cursor c,
        String[] from, int[] to, int flags */
        var from = arrayOf(
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER)
        var to = intArrayOf(R.id.name,R.id.number)
        var cAdapter = SimpleCursorAdapter(this@MainActivity,
              R.layout.indiview, cursor,from,to,0 )
        lview.adapter = cAdapter
    }
}
