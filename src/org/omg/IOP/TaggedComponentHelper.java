package org.omg.IOP;


/**
* org/omg/IOP/TaggedComponentHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /HUDSON/workspace/8-2-build-macosx-x86_64/jdk8u5/2488/corba/src/share/classes/org/omg/PortableInterceptor/IOP.idl
* Tuesday, March 18, 2014 12:37:22 AM PDT
*/

abstract public class TaggedComponentHelper
{
  private static String  _id = "IDL:omg.org/IOP/TaggedComponent:1.0";

  public static void insert (org.omg.CORBA.Any a, org.omg.IOP.TaggedComponent that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static org.omg.IOP.TaggedComponent extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_ulong);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (org.omg.IOP.ComponentIdHelper.id (), "ComponentId", _tcOf_members0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "tag",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_octet);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "component_data",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (org.omg.IOP.TaggedComponentHelper.id (), "TaggedComponent", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static org.omg.IOP.TaggedComponent read (org.omg.CORBA.portable.InputStream istream)
  {
    org.omg.IOP.TaggedComponent value = new org.omg.IOP.TaggedComponent ();
    value.tag = istream.read_ulong ();
    int _len0 = istream.read_long ();
    value.component_data = new byte[_len0];
    istream.read_octet_array (value.component_data, 0, _len0);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, org.omg.IOP.TaggedComponent value)
  {
    ostream.write_ulong (value.tag);
    ostream.write_long (value.component_data.length);
    ostream.write_octet_array (value.component_data, 0, value.component_data.length);
  }

}
