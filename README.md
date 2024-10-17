# Flocking Simulator

A basic java app that simulates the grouping of birds.

### Production

When designing how the algorithm would handle flocking, I planned on having each individual entity to interact with the entities surrounding them based on radius. This would allow entities that aren’t nearby to work independently, meanwhile those closer will group together.

At this point, I decided to plan my implementation of the aforementioned features. I decided to split the packages up depending on what they would be handling. For this I placed the Canvas.java class into its own package called background. Anything related to the geometry would sit in a package labelled as such. All the construction tools would sit in a packaged named as such too, while everything else would come together in a main package. I also planned on the main package coming together under a main.java class where all the other elements would compile together and produce the resultant application. For the most part this format was followed through for the application.

A plan for the flocking element at this phase which would revolve around grouping the entities. Ideally, I planned on creating something that can effectively merge multiple entities under the control of the original single primary entity. To do this I was thinking of using some sort of detection when the entities appeared close to each other, although the actual execution of this I was unsure of at this early planning phase.

As for additional features, I planned on implementing a predatory aspect where the grouped entities would scatter if a larger different coloured entity came in close proximity. The speed of this would be configurable with sliders and will have separate add and delete buttons.

### Implementation

The overall implementation was oriented around the supplied Canvas.java, Utils.java and LineSegment.java classes. The CartesianCoordinate.java class was created early on and was the fundamental way of handling how the turtles would move. At this early stage of development, the focus was using the lab material to construct a way of drawing a turtle on screen, using JPanel to do this. I decided reading the vast library of documentation associated with this would be the best starting point. This subsequently allowed me to create a turtle that could be drawn onto the canvas using the putPenDown() and putPenUp() functions. At the same time I decided to take the initiative to create the buttons too using the panel.add(new JButton) function. The buttons did nothing currently and just acted as a placeholder. To draw the turtle, I used basic turning and moving with the pen to draw a triangle with a line indicating the direction the turtle is facing.

Basic movement then became a priority, which involved the already created drawing, with follow up undraw(), and update() functions. This allowed the turtle to move forward in a linear fashion while undrawing the place it was previously. The next issue was dynamic movement where the turtle would vary the x and y coordinates as it moves in various directions. Once this was completed a small issue was apparent where the turtle would move off screen; the line drawing would cause to draw across the whole canvas.

The wrapPosition() function was used to handle this where the turtle would run this before updating and redrawing. This issue came about due to fixing a previous issue, where a turtle would disappear off the screen with exponentially increasing x and y coordinates causing it to remain as an entity but will be drawn so far off screen that it isn’t visible. Limiting the canvas fixed this problem, however would cause elements of the turtle to draw in directions that weren’t intended.

Before the previously mentioned fix was implemented, I focused my attention on the JPanel sliders and buttons, which I would use to create multiple turtles, predators (remains a placeholder for now) and the ability to remove the turtles. The left-hand sliders would at present simply allow the turtles on screen to increase in speed. This changes variably between zero and one thousand. The other two sliders found in the image above didn’t do anything at the time the was taken picture.

Next, I decided to turn my attention to the flocking algorithm which can be found under the subtitle below this segment. During the development of a functioning algorithm, it came apparent that there was a lot of waste code that wasn’t being used for anything. I decided to comment a lot of this out for a much cleaner future implementation, this included the predator buttons and sliders that weren’t being used.

Now some additional real estate was available, I decided to place some useful information to the user on the screen. This included a total number of turtle entities that were currently drawn on screen, alongside the number of which were considered grouped entities (more on this under the algorithm). I opted for this feature instead of focusing my attention to a working predator as I felt it would give more information to the user that would otherwise be filled by extra buttons. This subjectively gave the simulation a more user-friendly feel which I felt was important to the end user.

Alongside the changes to the buttons, I also decided to change the parameters of the sliders. The notable changes for this were the limits for assigned to turtle speed, which was changed to between 50 and 1000. The listed speed value to the right of this slider now accurately represented this speed in real time too. The max group size slider was also changed, to accommodate a max flock size of between 2 and 100. Again, this would update in real time to the right-hand side of the slider. I also tested this to make sure when the text expanded, the sliders will expand outwards and remain centralised. This is to fill the additional room the larger numbers will fill.

### The algorithum

To handle the flocking aspect of the application, I decided that a “hitbox” style method would be most appropriate for handling detection. This would involve placing an invisible region around the front end of the turtle (where the coordinates of the turtle are defined) and checking if they overlap with another turtle in that vicinity. This would therefore create a group that these turtles would sit under. To test this I coloured this region and added a printin() to see if they were actually colliding.

When two of the independently moving turtles come close enough for their magenta boxes to overlap, they’re considered to be a flock and group/move together as one entity. I chose to keep the hitbox slightly towards the front end of the turtle for two reasons, the first it was easier to implement this way. All the coordinates for the turtle revolve around where the front of the turtle is located so basing my hitbox around this was simple. The second reason is because I feel that a turtle should have greater peripheral vision towards the front.

My ideal implementation of this was to have each turtle that came into contact with one another to add themselves to a group. When handling and testing this segment of the application, I decided that scaling up the size of the hitbox in relation to the number of turtles in the group would work best. A group of turtles at this stage would be indicated using a red turtle, which represents a group of turtles combined. The grouped turtles are represented using a red arrow and a larger hitbox, while non-grouped turtles do not.

As the slider at the lower right-hand corner of the image is set to just 5, and the size of the group is already 5, despite the fact that another turtle is overlapping the hitbox, it isn’t added to the group. To follow up from this, multiple turtles were brought into existence and the group size was raised to 100 to see if they group correctly.

The drawing of additional turtles that are members of groups hadn’t been developed yet, each group is presently represented by a single entity and has an ever-increasing hitbox. The largest hitboxes in the image above represent turtles with the maximum group size of 100. This was done to test whether the delete turtle button would remove the turtles that are members of large groups, which it does. By clicking the remove turtle button, 1 turtle from the latest group will decrease by 1 and subsequently so does the hitbox size. This will eventually become the underlying fundamentals for the flocking algorithm.

The next issue I came across was drawing all the individual turtles that are members of their corresponding groups. For my first test implementation of the design, the drawn elements overlap in a way that wasn’t entirely what I was looking for.

the turtles are overlapping quite heavily and just looks like a mess of scribbles, especially when seen not moving. To fix this issue, the randomly selected area around the turtle was increase so that drawn entities don’t overlap as much.

After this phase the spacing was fixed and the hitboxes were hidden which brings the application onto its final form in terms of the algorithm.

### Conclusion

To conclude the project, I developed an application that contained a flocking aspect with a couple additional features, however these features did differ from what I originally planned. For example, the idea of using a predatory entity to interact with the grouped turtles was scrapped for counters instead. A decent portion of the residue code will remain in the application so show what my thought process was when making the app.
