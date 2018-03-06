# Islands

Created this app as a recruitment task.

The task is about finding islands on rectangular-grid-ocean maintaining best possible memory complexity. 

Performance however is greatly degraded.

I used algorithm of my own invention which enables to process great amount of data with negligible memory usage growth. 

To run the code one's need to implement its own main method.

The algorithm implementation is explained in maciek.islands.impl.Jeep class javadoc.

It relies on sequence of searching map's fields. Different sequences are possible however since sequence doesn't depend on islands layout some combinations of islands which are more memory consuming are possible. If I spend more time on this task I would make the sequence depending on the layout.